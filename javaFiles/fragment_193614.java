@Test
void test() throws IOException {
    ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
    List<Requirement> requirements = mapper.readValue(new File("src/test/resources/requirements.yml"), new TypeReference<List<Requirement>>() {});
    assertEquals(2, requirements.size());
}