Reflections reflections = new Reflections(new ConfigurationBuilder()
        .setUrls(Arrays.asList(ClasspathHelper.forClass(List.class))));

Set<Class<? extends List>> subTypes = reflections.getSubTypesOf(List.class);
for (Class c : subTypes) {
    System.out.println("subType: " + c.getCanonicalName());
}