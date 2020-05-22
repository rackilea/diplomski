UserModel user = Hawk.get("user");
     Intent intent;
     if (user != null) //if the user is null then the user was deleted from the logout process!
     intent = new Intent(Splash.this, MyHome.class);
     else
     intent = new Intent(Splash.this, LoginActivity.class);
     startActivity(intent);