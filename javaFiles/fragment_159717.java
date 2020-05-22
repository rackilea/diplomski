public void checkLogin(){
    // Check login status

    editor.putBoolean("login", true);// even if add true it will return false
    editor.commit();

    if(!this.isLoggedIn()){
        Toast.makeText(_context, " Login", Toast.LENGTH_SHORT).show();