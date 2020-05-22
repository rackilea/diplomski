mKinveyClient.user().create("username", "password", new KinveyUserCallback()) {
    @Override
    public void onFailure(Throwable t) {
        CharSequence text = "Could not sign up.";
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onSuccess(User u) {
        //here we go on uploading file
    }
});