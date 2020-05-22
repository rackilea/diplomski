//Saving
if(appUser == null){
    Log.e("MainActivity", "Create new User");
    appUser = new User();
    try{
        FileOutputStream fos = this.getApplicationContext()
                .openFileOutput("UserData.data", Context.MODE_PRIVATE);
        ObjectOutputStream os = new ObjectOutputStream(fos);
        os.writeObject(this);
        ...