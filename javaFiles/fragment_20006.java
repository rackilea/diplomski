public String createJavadoc(final IMethod method, final String indent, final String lineSeparator,
        final JavadocInfo jdi) throws JavaModelException {

    final List<String> text = jdi.getComment();
    if (text.isEmpty()) {
        if (config.isCreateDummyComment()) {
            if (method.isConstructor()) {
                text.add(Constants.JDOC_CONSTRUCTOR);
            }
            else if (method.isMainMethod()) {
                text.add(Constants.JDOC_MAIN);
            }
            else {
                String comment = CommentManager.createComment(config, method.getElementName(),
                        CommentManager.METHOD, true, true, CommentManager.FIRST_TO_UPPER);
                text.add(comment + Constants.DOT);
            }
        }
        else {
            text.add("");
        }
    }
    else {
        checkForDot(text);
    }