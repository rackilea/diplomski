import com.google.gson.Gson;

class JsonCheck{
    public static void main(String args[]) {
        Details details = null;
        String json = "{\"id\":\"1tr0vm\",\"title\":\"Professional business consultant in Cookeville, TN at IAG\",\"category\":\"business\"}";
        Gson gsoObj = new Gson();
        details = gsoObj.fromJson(json, Details.class);
        System.out.println(details.id);
    }

    private class Details {
        private String id = "";
        private String title = "";
        private String category = "";
    }
}