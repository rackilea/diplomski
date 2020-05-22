public InputStream getFileStream(String environmentName) {
    Container container = getContainerID(environmentName);
    String url = "";
    if(container != null) {
        Settings settings = Settings.getSettings();
        url = "http://" + settings.getDockerIP() + ":" + settings.getDockerPort() + "/containers/" + container.getId() + "/archive?path=/path/file";
    }
    InputStream is = new URL(url).openStream();

    return is; 
}