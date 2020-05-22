class MyApplication extends Application {
    @Override
    public Map<String, String> getProperties() {
        Map<String, String> props = new HashMap<>();
        props.put("jersey.config.disableMoxyJson", "true");
        return props;
    }
}