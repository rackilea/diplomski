public static void readYaml() {
    Yaml yaml = new Yaml();
    InputStream is = App.class.getResourceAsStream("example.yaml");

    Map<String, List<YamlEntity>> ye = yaml.load(is);
    System.out.println(ye.get("value"));
}