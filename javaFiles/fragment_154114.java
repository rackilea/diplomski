String lng = "en";
Locale loc = new Locale(lng);
String name = loc.getDisplayLanguage(loc); // English

lng = "es";
loc = new Locale(lng);
name = loc.getDisplayLanguage(loc); // español

//...