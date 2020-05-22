private Context context;
private ListView mListView;
private ArrayAdapter<String> adapter;
private List<String> titleList = new ArrayList<String>();

public NewPostsAsyncTask(Context context, ListView listview) {
        this.context = context;
        this.mListView = listview;
    }

private void parseDocument(Document doc) {
        // Парсит посты на странице
        content = doc.select("[style=margin:0.5em 0;line-height:1.785em]");

        for (Element contents : content) {
            if (!contents.text().contains("18+")) {
                // Выводит только посты без ссылки на 18+
                titleList.add(contents.text());
            }
        }
    }


    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        adapter = new ArrayAdapter<String>(context, R.layout.list_item, R.id.item, titleList);
        mListView.setAdapter(adapter);
        progressDialog.dismiss();
    }
}