String mavenHomePath = System.getProperty("maven.home");

if (mavenHomePath == null) {
    Map<String,String> filteredMap = new HashMap<>();
    final List<String> searchEnv = Arrays.asList(new String[]{"m3_home", "m3home", "m2_home", "m2home", "maven_home", "mavenhome", "path"}); 
    for (final Map.Entry<String, String> entry : System.getenv().entrySet()) {
        final String key = entry.getKey().toLowerCase();
        if (searchEnv.contains(key)){
            filteredMap.put(key, entry.getValue());
        }
    }
    for (String key : searchEnv) {
        for (final String pathEnv : filteredMap.values()) {
            for (final String path : pathEnv.split(File.pathSeparator)) {
                mavenHomePath = checkForMavenHomeIn(new File(path));
                if (mavenHomePath != null) break;
            }
            if (mavenHomePath != null) break;
        }
        if (mavenHomePath != null) break;
    }
}

System.setProperty("maven.home", mavenHomePath);

invokeYourPlugIn();