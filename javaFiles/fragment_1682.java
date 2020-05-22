private void signOut() {
Auth.GoogleSignInApi.signOut(mGoogleApiClient).setResultCallback(
        new ResultCallback<Status>() {
            @Override
            public void onResult(Status status) {
             Intent intent1 = new Intent(getContext(),LoginActivity.class);
             startActivity(intent1);
             getActivity().finish();
            }
        });
}