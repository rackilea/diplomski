String name = "";
String email = "";
String pass = "";
String contact = "";

Bundle extras = getIntent().getExtras();

if(extras != null){ 

  name = extras.getString("name");
  email = extras.getString("email");
  pass = extras.getString("pass");
  contact = extras.getString("contact");

 }