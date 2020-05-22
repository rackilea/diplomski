private String sanitizeScript(String script) {
    if (containsMoreThanOneStatement(script)) {
        throw new ScriptedPermissionsException("Scripts may only contain one statement!!");
    }
    return new StringBuilder()
            .append("function importPackage(a){ throw 'Cannot import!'};").append('\n')
            .append("function importClass(a){ throw 'Cannot import!'};").append('\n')
            .append("function JavaImporter(a){ throw 'I said, no importing!!'};").append('\n')
            .append(script).append(';')
            .toString();
}