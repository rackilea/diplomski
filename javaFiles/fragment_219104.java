@Override
protected void onPostExecute (JSONObject returned) {
    Gson gson = new Gson();
    PostsHandler ph = gson.fromJson(returned.toString(), PostsHandler.class);

    System.out.println("Article array length: " + ph.getArticles().size());
    stories = arts;
    populateUI();
}