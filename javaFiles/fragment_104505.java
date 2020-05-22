public void onSuccess(LoginResult loginResult) {
    GraphRequest.newMeRequest(
            loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                @Override
                public void onCompleted(JSONObject user, GraphResponse response) {
                    if (response.getError() != null) {
                        //process error
                    } else {
                        id = user.optString("id");
                        firstName = user.optString("first_name");
                        lastName = user.optString("last_name");
                        email = user.optString("email");
                        Log.i(TAG,"User ID "+ id);
                        Log.i(TAG, "Email " + email);

                        Name = firstName + " " + lastName;
                        Toast.makeText(getApplicationContext(), "Log in with " + Name, Toast.LENGTH_LONG).show();

                        //adding this:
                        Intent i = new Intent();
                        i.putExtra("Name", Name);
                        LoginActivity.this.setResult(RESULT_OK, i);
                        LoginActivity.this.finish();
                    }


                }
            }).executeAsync();
}