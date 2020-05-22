public Resource[] getSchemas() {
    List<Resource> schemaResources = new ArrayList<>();
    schemaResources.add(new ClassPathResource("firstService.xsd"));
    schemaResources.add(new ClassPathResource("secondService.xsd"));
    schemaResources.add(new ClassPathResource("thirdService.xsd"));
    return schemaResources.toArray(new Resource[schemaResources.size()]);
}