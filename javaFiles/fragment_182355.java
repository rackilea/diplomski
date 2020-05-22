public class RestAppication extends Application {

    @Override
    public Map<String, Object> getProperties() {
        Map<String, Object> props = new HashSet<>();

        String classnames = JacksonFeature.class.getName();
        props.put("jersey.config.server.provider.classnames", classnames);
        props.put("jersey.config.disableMoxyJson", true);
        return props;
    }
}