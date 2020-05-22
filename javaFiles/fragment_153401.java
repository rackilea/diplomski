public static void main(String[] args)
{
    String fullDetailsJson = "{\"details\": {\"name\":\"My Details\"}} ";
    String emptyDetailsJson = "{\"details\": false} ";
    ObjectMapper mapper = new ObjectMapper();
    try {
        Details details = mapper.readValue(fullDetailsJson, Details.class);
        System.out.println(details.name);
        details = mapper.readValue(emptyDetailsJson, Details.class);
        System.out.println(details);
    } catch (Exception e) {
        e.printStackTrace();
    }
}