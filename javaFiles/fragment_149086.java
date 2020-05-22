@Autowired 
private ObjectMapper objectMapper;

@Test
public void shouldOutputEmpty() {
  Map<String, Object> obj = new HashMap<>();
  obj.put("a", null);
  String result = objectMapper.writeValueAsString(obj);
  assertThat(result).isEqualTo("{}");
}