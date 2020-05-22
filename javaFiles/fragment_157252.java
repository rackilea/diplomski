public class BookCatalog implements GetJSONListener {
    private final String TAG = this.getClass().getSimpleName();

    private String catalog_url = "URL";

    private void getCatalogFromServer() {

        URLWithParams mURLWithParams = new URLWithParams();
        mURLWithParams.url = catalog_url;

        try {
            JSONClient asyncPoster = new JSONClient(this);
            asyncPoster.execute(mURLWithParams);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void onRemoteCallComplete(String jsonBookCatalogList) {

        Log.d(TAG, "received json catalog:");
        Log.d(TAG, jsonBookCatalogList);
    JSONObject bookCatalogResult;
    try {
        bookCatalogResult = (JSONObject) new JSONTokener(jsonBookCatalogList).nextValue();
        JSONArray books = bookCatalogResult.getJSONArray("books");

        if(books != null) {
            ArrayList<String> newBookOrdering = new ArrayList<String>();
            int num_books = books.length();
            BookCatalogEntry temp;

            DebugLog.d(TAG, "apparently we found " + Integer.toString(num_books) + " books.");
            for(int book_id = 0; book_id < num_books; book_id++) {
                JSONObject book = books.getJSONObject(book_id);
                String title = book.getString("title");
                int version = book.getInt("price");
            }
        }

    } catch (JSONException e) {
        e.printStackTrace();
    } 

    }


}