public class MyCustomContextListener extends GenericXmlContextLoader implements ContextLoader {
    @Override
    protected String[] generateDefaultLocations(Class<?> clazz) {
        List<String> locations = newArrayList(super.generateDefaultLocations(clazz));
        locations.addAll(ImmutableList.copyOf(findAdditionalContexts(clazz)));
        return locations.toArray(new String[locations.size()]);
    }

    @Override
    protected String[] modifyLocations(Class<?> clazz, String... locations) {
        List<String> files = newArrayList(super.modifyLocations(clazz, locations));
        files.addAll(ImmutableList.copyOf(findAdditionalContexts(clazz)));
        return files.toArray(new String[files.size()]);
    }

    private String[] findAdditionalContexts(Class<?> aClass) {
        // Look for annotations and return 'em
    }
}