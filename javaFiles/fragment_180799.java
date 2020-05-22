private void initFacebook() 
{
    try
    {
        if (APP_ID == null) 
        {
            Util.showAlert(this,"Warning","Facebook Applicaton ID must be "+ "specified before running this example: see Example.java");
        }

        mFacebook = new Facebook();
        mAsyncRunner = new AsyncFacebookRunner(mFacebook);
        mFacebook.authorize(FacebookList.this, APP_ID, new String[] {"email", "read_stream", "user_hometown", "user_location","friends_about_me", "friends_hometown", "friends_location","user_relationships", "friends_relationship_details","friends_birthday", "friends_education_history","friends_website" }, new DialogListener()
        {
            public void onComplete(Bundle values) 
            {
                getHTTPConnection();
            }

            public void onFacebookError(FacebookError error) 
            {
                Log.i("public void onFacebookError(FacebookError error)....","....");
            }

            public void onError(DialogError e) 
            {
                Log.i("public void onError(DialogError e)....", "....");
                CustomConfirmOkDialog dialog = new CustomConfirmOkDialog(FacebookList.this, R.style.CustomDialogTheme, Utils.FACEBOOK_CONNECTION_ERROR);
                dialog.show();
            }

            public void onCancel() 
            {
                Log.i("public void onCancel()....", "....");
            }
        });

        SessionStore.restore(mFacebook, this);
        SessionEvents.addAuthListener(new SampleAuthListener());
        SessionEvents.addLogoutListener(new SampleLogoutListener());
    }
    catch (Exception e) 
    {
        e.printStackTrace();
    }
}