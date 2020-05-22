Intent intent = getIntent();

if (intent != null && intent.hasExtra("MemberID")) {
    long memberid = intent.getLongExtra("MemberID", -1);
    // TODO: get customer details based on customer id
    intent.putExtra("MemberID", memberid);
    startActivity(intent);
}
else {
    Toast.makeText(
            getApplicationContext(),
            R.string.empty_not_saved,
            Toast.LENGTH_LONG).show();
}