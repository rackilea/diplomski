//Here, we PUT the arraylist into the sharedPreferences/*
SharedPreferences sharedPreferencescheckedContactsAsArrayList = PreferenceManager.getDefaultSharedPreferences(getApplication());
SharedPreferences.Editor editorcheckedContactsAsArrayList = sharedPreferencescheckedContactsAsArrayList.edit();
Gson gsoncheckedContactsAsArrayList = new Gson();
String jsoncheckedContactsAsArrayList = gsoncheckedContactsAsArrayList.toJson(checkedContactsAsArrayList);
                              editorcheckedContactsAsArrayList.putString("checkedContactsAsArrayList", jsoncheckedContactsAsArrayList);
editorcheckedContactsAsArrayList.commit();