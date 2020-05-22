public static void store(Properties properties, Class script) throws IOException {
    ScriptManifest scriptManifest = (ScriptManifest) script.getAnnotation(ScriptManifest.class);
    if (scriptManifest != null) {
        String name = scriptManifest.name();
        try ( FileOutputStream outputStream = new FileOutputStream(Constants.SCRIPT_PROPERTIES_DIR + File.separator + name + ".properties") ) {
            properties.store(outputStream, "");
        }
    } else {
        throw new RuntimeException("Script " + script.getName() + " does not have a ScriptManifest.");
    }
}