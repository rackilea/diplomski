public class JacksonTest {
    @Test
    public void test1() throws IOException {
        String test = "[{\"id\" : null, \"listId\" : 1, \"wwid\" : \"abc123\"}]";
        UserAccessListMembers[] userAccessListMemberses = new ObjectMapper().readValue(test, UserAccessListMembers[].class);
        for (UserAccessListMembers members : userAccessListMemberses) {
            System.out.println(members);
        }
    }
}