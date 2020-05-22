@Autowired
private ObjectMapper objectMapper;
private Resource expectedResult = new ClassPathResource("expected.json");

@Test
public void jsonMatches() {
    Foo requestBody = new Foo();
    String json = objectMapper.writeValueAsString(requestBody);
    String expectedJson = Files
        .lines(expectedResult.getFile())
        .collect(Collectors.joining());
    JSONAssert.assertEquals(expectedJson, json, JSONCompareMode.LENIENT);
}