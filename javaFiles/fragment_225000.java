protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (resultCode == RESULT_OK) {
        IdpResponse idpResponse = IdpResponse.fromResultIntent(data);
        startActivity(new Intent(this, WelcomeBackActivity.class)
                .putExtra("my_token", idpResponse.getIdpToken()));
    }
}

Twitter also returns an AuthToken Secret which can be accessed with idpResponse.getIdpSecret().