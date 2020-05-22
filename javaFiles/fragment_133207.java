**${installer:language}**

String language = context.getVariable("language").toString();
String languageId = context.getVariable("sys.languageId").toString();

if(languageId.length() >= 2){

  language = languageId.substring(0,2);
}

return language;