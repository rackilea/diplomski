public final class AntBuildfileContentDescriber extends XMLContentDescriber {
    private int checkCriteria(InputSource contents) throws IOException {
        AntHandler antHandler = new AntHandler();
        try {
            if (!antHandler.parseContents(contents)) {
                return INDETERMINATE;
            }
        }
        catch (SAXException e) {
            // we may be handed any kind of contents... it is normal we fail to parse
            return INDETERMINATE;
        }
        catch (ParserConfigurationException e) {
            // some bad thing happened - force this describer to be disabled
            String message = "Internal Error: XML parser configuration error during content description for Ant buildfiles"; //$NON-NLS-1$
            throw new RuntimeException(message);
        }
        // Check to see if we matched our criteria.
        if (antHandler.hasRootProjectElement()) {
            if (antHandler.hasProjectDefaultAttribute() || antHandler.hasTargetElement() || antHandler.hasAntElement()) {
                // project and default attribute or project and target element(s)
                // or project and top level ant element(s) (classpath, import, macrodef, path, property, taskdef, typedef)
                return VALID;
            }
            // only a top level project element...maybe an Ant buildfile
            return INDETERMINATE;
        }

        return INDETERMINATE;
    }

    @Override
    public int describe(InputStream contents, IContentDescription description) throws IOException {
        // call the basic XML describer to do basic recognition
        if (super.describe(contents, description) == INVALID) {
            return INVALID;
        }
        // super.describe will have consumed some chars, need to rewind
        contents.reset();
        // Check to see if we matched our criteria.
        return checkCriteria(new InputSource(contents));
    }

    public int describe(Reader contents, IContentDescription description) throws IOException {
        // call the basic XML describer to do basic recognition
        if (super.describe(contents, description) == INVALID) {
            return INVALID;
        }
        // super.describe will have consumed some chars, need to rewind
        contents.reset();
        // Check to see if we matched our criteria.
        return checkCriteria(new InputSource(contents));
    }
}