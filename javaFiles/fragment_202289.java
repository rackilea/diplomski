try 
{
    JSONObject result = new JSONObject(resultResponse);
    String kind = result.getString("kind");

    JSONArray items_arr=result.getJSONArray("items");
    for(int i=0;i<items_arr.length();i++)
    {
        JSONObject obj=items_arr.getJSONObject(i);
        JSONObject volumeInfo_obj=obj.getJSONObject("volumeInfo");
        String bookName=volumeInfo_obj.getString("title");
        JSONArray volumeInfo_arr=volumeInfo_obj.getJSONArray("authors");
        String authorName=volumeInfo_arr.getString(0);

        String publicationDate=volumeInfo_obj.getString("publishedDate");

        bookList.add(new Book(bookName, authorName, publicationDate));
    }
    BookAdapter bookAdapter = new BookAdapter(this, bookList);
    listView.setAdapter(bookAdapter);

} catch (JSONException e) {
    Constants.dismiss_progress_dialog();
    e.printStackTrace();
}