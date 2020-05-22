@Mock
Service service;

@Mock
JdbcTemplate jdbcTemplate;


@Test
public void testGetUserNames() {

    List<String> userNames = new ArrayList<String>();
    userNames.add("bob");

    when(service.getJdbcTemplate()).thenReturn(jdbcTemplate);
    when(jdbcTemplate.query(anyString(), anyObject()).thenReturn(userNames);

    String retVal = Class.getUserNames("test");
    assertEquals("bob", retVal);
}