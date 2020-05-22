@Override
protected Void doInBackground(Object... arg0) {
    if(arg0[0].equals("login")){
        output = "login";
        dologin();
    }
    return null;
}