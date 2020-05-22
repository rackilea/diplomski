Intent intent = getIntent();
if (intent != null){
    user = (User) intent.getSerializableExtra("user");
    if (user == null){
        //handle null user
    }
} else {
    //here you can call finish() if the user is fundamental to your Activity
    //or you must handle a possible nullable `User` object in the following code
    finish();
    return;
}