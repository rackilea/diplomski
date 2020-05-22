public ActionMapping getMapping(HttpServletRequest request,
                                ConfigurationManager configManager) {
    ActionMapping mapping = new ActionMapping();
    String uri = getUri(request);

    int indexOfSemicolon = uri.indexOf(";");
    uri = (indexOfSemicolon > -1) ? uri.substring(0, indexOfSemicolon) : uri;

    uri = dropExtension(uri, mapping);
    if (uri == null) {
        return null;
    }

    parseNameAndNamespace(uri, mapping, configManager);

    handleSpecialParameters(request, mapping);

    if (mapping.getName() == null) {
        return null;
    }

    parseActionName(mapping);

    return mapping;
}