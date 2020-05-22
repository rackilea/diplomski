import com.google.gson.Gson;

public class Main {
    public static void main (String[] args) {
        String json =   "{\n" +
                        "    \"author\": \"Jack\",\n" +
                        "    \"comment_body\": \"Any message body\",\n" +
                        "    \"replies\": {\n" +
                        "        \"author\": \"John\",\n" +
                        "        \"comment_body\": \"Reply body\",\n" +
                        "        \"replies\": {\n" +
                        "            \"author\": \"Smith\",\n" +
                        "            \"comment_body\": \"Another reply body\",\n" +
                        "            \"replies\": null\n" +
                        "        }\n" +
                        "    }\n" +
                        "}\n";
         Comment comment = new Gson().fromJson(json, Comment.class);
         System.out.println(comment);
    }
}