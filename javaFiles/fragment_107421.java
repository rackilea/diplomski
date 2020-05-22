public class Test {

    private static final String JSON = "[{\"id\":1025,\"key\":\"SVS\",\"prj_name\":\"SVS\",\"prj_scope\":\"PR8\",\"prj_qualifier\":\"WW\",\"date\":\"2016-03-29T06:00:26-0400\",\"creationDate\":\"2013-04-12T09:03:35-0400\",\"prj_lname\":\"SVS\",\"csr\":[{\"key\":\"test_success\",\"test_output\":85.3,\"org_val\":\"78.3%\"}]}]";

    public static void main(String[] args) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = mapper.readTree(JSON);
        System.out.println(actualObj.findValue("test_output"));
    }

}