WebClient client = new WebClient();
Page page = client.getPage("https://stackoverflow.com/users/flair/97901.json");
WebResponse response = page.getWebResponse();
if (response.getContentType().equals("application/json")) {
    String json = response.getContentAsString();
    Map<String, String> map = new Gson().fromJson(json, new TypeToken<Map<String, String>>() {}.getType());
    System.out.println(map.get("displayName")); // Benju
}