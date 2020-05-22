**${installer:country}**

String country = context.getVariable("country").toString();
String languageId = context.getVariable("sys.languageId").toString();

if(languageId.length() == 2){

  country = " ";

}else if(languageId.length() > 2){

  country = languageId.substring(3, 5);

}

return country;