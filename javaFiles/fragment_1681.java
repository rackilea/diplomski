google.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        Intent intent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(intent, requestCode);

        Toast.makeText(getContext(),"User Name "+ acc.getDisplayName()+ "Mail  "+acc.getEmail(), Toast.LENGTH_LONG).show();
    }
});