public static void store(Properties properties, Class script) throws IOException {
    ScriptManifest scriptManifest = (ScriptManifest) script.getAnnotation(ScriptManifest.class);
    if (scriptManifest != null) {
        String name = scriptManifest.name();
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(Constants.SCRIPT_PROPERTIES_DIR + File.separator + name + ".properties");
            properties.store(outputStream, "");
        } finally {
            if ( outputStream != null ) outputStream.close();
        }
    } else {
        throw new RuntimeException("Script " + script.getName() + " does not have a ScriptManifest.");
    }
}