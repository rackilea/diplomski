@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://stackoverflow.com"));
        startActivity(intent);
        finish();

    }