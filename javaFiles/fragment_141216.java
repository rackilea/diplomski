void logOut(){
    SharedPreferences blockSession = this.getSharedPreferences("blockSession", 0);
    SharedPreferences.Editor blockEdit = blockSession.edit();
    blockEdit.clear();
    blockEdit.apply();
    //finish();       /****<-----commented out this line---****/
    Intent intent = new Intent(Mainpage.this, Authentication.class);
    startActivity(intent);

    finish();        /****<------Moved to here---****/
}