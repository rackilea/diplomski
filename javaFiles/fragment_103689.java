import com.google.gson.Gson;

public class Answers {
    public static void main(String[] args) {
        String json = "{" 
                + "    \"id\": 1,"
                + "    \"title\": \"Title blabla\"," + "    \"thing\": {"
                + "        \"field1\": 1," + "        \"field2\": \"field2\","
                + "        \"etc\": \"etc..\"" + "    }" 
                + "}";
        Gson gson = new Gson();
        MyModel myModel = (MyModel) gson.fromJson(json, MyModel.class);
        System.out.println(gson.toJson(myModel));

    }

    class MyModel {
        private int id;
        private String title;
        private Object thing;
    }

}