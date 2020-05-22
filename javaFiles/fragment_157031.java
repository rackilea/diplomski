public class Test extends Connection {
.......

    @Test
    public void test_Insert() {
        Map<Object, String> mapRequest = new HashMap<>();
        mapRequest.put("id", "564624232443234");
        mapRequest.put("type", "book");

        given().
            contentType(ContentType.JSON).  
            header("Authorization", "Basic "+"cJJdlJ26p62JG23j34==").
            body(Collections.singletonMap("test",mapRequest)).
        when().
            post("test").
        then().
            statusCode(200);

    }
}