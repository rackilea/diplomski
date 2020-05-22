private String[] getFileListing(String servers) throws IOException {
    List<String> allowedExtensions = Arrays.asList("log txt".split(" "));
    Properties prop = new Properties();
    String propFileName = "config.properties";
    InputStream input = getClass().getClassLoader().getResourceAsStream(propFileName);
    prop.load(input);

    File f = new File(prop.getProperty("path." + servers));
    String[] list = f.list(new FilenameFilter() {
        public boolean accept(File dir, String name) {
            return allowedExtensions.contains(name.substring(name.lastIndexOf(".") + 1, name.length()));
        }
    });
    return list;
}