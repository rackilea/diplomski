public class App {
    public static void main(String[] args) {
        Gson gson = new Gson();
        String jsonString = "{\"directory\": {\"employees\": {\"employee\": [{\"field\": [{\"content\": \"Charlotte Abbott\",\"id\": \"displayName\"},{\"content\": \"Charlotte\",\"id\": \"firstName\"}]}]}}}";

        Wrapper obj = (Wrapper) gson.fromJson(jsonString, Wrapper.class);

        System.out.println(obj.getDirectory().getEmployees().getEmployeeList()
                .get(0).getFieldList().get(0).getContent());
    }
}