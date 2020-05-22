**${installer:variant}**

String variant = context.getVariable("variant").toString();
String languageId = context.getVariable("sys.languageId").toString();

if(languageId.length() < 8){

  variant = " ";

}else{       
    variant = languageId.substring(6, 8);         
}

return variant;