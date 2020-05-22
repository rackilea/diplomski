private getHostNameFromConfigFile(String configFile, String defaultHostName) {
    try {
        BufferedReader reader = new BufferedReader(new FileReader(configFile));
        return reader.readLine();
    } catch (IOException e) {
        return defaultHostName;
    }
}
public Collection<String> readServerHostnames(File mainServerConfigFile, File  backupServerConfigFile) {
    String mainServerHostname=getHostNameFromConfigFile(mainServerConfigFile,"default- server.example.org");
    String backupServerHostName=getHostNameFromConfigFile(backupServerConfigFile,"default- server.example.ru")
    return Arrays.asList(mainServerHostname,backupServerHostName );
}