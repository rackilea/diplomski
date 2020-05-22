public void loginToFacebook(){
        facebook.authorize(CandyCount.this, new String[]{"publish_stream", "email"}, Facebook.FORCE_DIALOG_AUTH, new DialogListener() {

            public void onFacebookError(FacebookError e) {
                Toast.makeText(getApplicationContext(), "onFacebookError", Toast.LENGTH_SHORT).show();
            }

            public void onError(DialogError e) {
                Toast.makeText(getApplicationContext(), "onError", Toast.LENGTH_SHORT).show();
            }

            public void onComplete(Bundle values) {

                Editor editor = sp.edit();
                editor.putString("access_token", facebook.getAccessToken());
                editor.putLong("access_expires", facebook.getAccessExpires());
                editor.commit();
                updateButtonStatus();

                getName();

            }

            public void onCancel() {
                // TODO Auto-generated method stub

            }

        });
    }