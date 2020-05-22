PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(ConfigMapping.class.getClassLoader());

Resource[] resources = resolver.getResources("classpath*:/META-INF/resources/mapper/*");

for (Resource resource: resources) {
 InputStream input = resource.getInputStream();
 Map < String, MappedContacts> jsonMap = new ObjectMapper().readValue(input, new TypeReference < Map < String, MappedContacts>> () {});
 mapping.putAll(jsonMap);
}