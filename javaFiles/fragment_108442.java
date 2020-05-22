@Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent mIntent = new Intent();
        String search = getIntent().getStringExtra("searchText");
        mIntent.putExtra("searchText", search);
        setResult(1, mIntent);
    }