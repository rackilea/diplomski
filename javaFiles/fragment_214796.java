@Test
public void test1() throws IOException {

UserAccountAuthentication userAccountAuthentication = new UserAccountAuthentication();
userAccountAuthentication.setAuthenticated(true);
userAccountAuthentication.getAuthorities().add(new SimpleGrantedAuthority("role1"));
userAccountAuthentication.getAuthorities().add(new SimpleGrantedAuthority("role2"));

String json1 = new ObjectMapper().writeValueAsString(userAccountAuthentication);
UserAccountAuthentication readValue = new ObjectMapper().readValue(json1, UserAccountAuthentication.class);
String json2 = new ObjectMapper().writeValueAsString(readValue);
assertEquals(json1, json2);