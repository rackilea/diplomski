class User extends Activity implements ResultConsumer<String> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SpecialAsyncTask.execute(Providers.HTTP_GETTER, this , "http://google.com");
        SpecialAsyncTask.execute(Providers.HTTP_GETTER, this , "http://yahoo.com");
    }

    @Override
    public void handleResultInForeground(String result) {
        Toast.makeText(this, result, Toast.LENGTH_LONG).show();
    }
}