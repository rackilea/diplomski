preferences.addPreference("is_logged", true);
preferences.addPreference("email", email);
preferences.addPreference("user_name", username);
preferences.addPreference("password", password);
preferences.addPreference("last_login",
DateHelper.getCurrentDate());
int uid = JsonHelper.getReturnID(result);
boolean is_admin, is_manager;
is_admin = JsonHelper.getBoolean(result, "is_admin");
is_manager = JsonHelper.getBoolean(result, "is_manager");
preferences.addPreference("is_admin", is_admin);
preferences.addPreference("is_manager", is_manager);
preferences.addPreference("uid", uid);
String phone, name;
phone = JsonHelper.getStringFromResult(result, "phone");
name = JsonHelper.getStringFromResult(result, "name");
preferences.addPreference("phone", phone);
preferences.addPreference("name", name);
startActivity(new Intent(StartingActivity.this,
MainActivity.class));