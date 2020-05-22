@PostConstruct
public void loadProp() {
    InputStream in = this.getClass().getClassLoader()
            .getResourceAsStream("config.properties");
    try {
        configProp.load(in);
    } catch (IOException e) {
        e.printStackTrace();
    }

    destination = configProp.getProperty("destination");
}