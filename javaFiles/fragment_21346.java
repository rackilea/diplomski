class Test {

    public static void main(String[] args) throws FileNotFoundException {
        String filePath = "path/to/configuartion/file/configuration.yaml";
        InputStream input = new FileInputStream(new File(filePath));
        Yaml yaml = new Yaml(new Constructor(Configuration.class));
        Configuration configuration = yaml.load(input);
    }
}