@Override
protected void onStart() {
    super.onStart();
    Intent intent = getIntent();

    if (Intent.ACTION_VIEW.equals(intent.getAction())) {
        Uri uri = intent.getData();

        SharedPreferences.Editor tEditor = getSharedPreferences("UserFormPreferences", MODE_PRIVATE).edit();

        tEditor.putString("GuestRoomNumber", uri.getQueryParameter("h"));
        tEditor.putString("GuestSurname", uri.getQueryParameter("a").replace("/",""));
        tEditor.apply();

        Intent tIntent = new Intent("epinom.jm.smarthotel.vcMainScreen");
        tIntent.putExtra("Login", "true");
        startActivity(tIntent);
        finish();
    }
}