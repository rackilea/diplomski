//we are fetching the array list checkedContactsAsArrayList, created in the activity. with this we will put a tick in the checkboxes of the selected numbers
SharedPreferences sharedPreferencescheckedContactsAsArrayList = PreferenceManager.getDefaultSharedPreferences(context_type);
Gson gsoncheckedContactsAsArrayList = new Gson();
String jsoncheckedContactsAsArrayList = sharedPreferencescheckedContactsAsArrayList.getString("checkedContactsAsArrayList", "");
Type type2 = new TypeToken<ArrayList<String>>() {
 }.getType();
checkedContactsAsArrayList = gsoncheckedContactsAsArrayList.fromJson(jsoncheckedContactsAsArrayList, type2);