static class Page {
    String code;
}

public static String checkIp() throws Exception {
    String json = readUrl("https://link.com/json.php");

    GsonBuilder gsonBuilder = new GsonBuilder();
    Gson gson = gsonBuilder.create();

    Page page = gson.fromJson(json, Page.class);
    Log.d("MainActivity", page.code);
    return Page.code;
}