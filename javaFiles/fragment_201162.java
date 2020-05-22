public class GetData extends AsyncTask<String, String,ArrayList<ArticleConstructor>>{
    Callback callback;

    interface Callback {
        void onArticleConstructorLoaded(ArrayList<ArticleConstructor> articleConstructors);
    }

    public GetData(Callback callback) {
        this.callback = callback;
    }

    ...

    @Override
    protected void onPostExecute(ArrayList<ArticleConstructor> result) {
        callback.onArticleConstructorLoaded(result);
    }
    ....
}