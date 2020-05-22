@Override
public void onClick(View view) {
    if (view == loginButton) {
        application.getAuth().getUser().setIsLoggedIn(true);
        callBacks.onLoggedIn();
    }
}