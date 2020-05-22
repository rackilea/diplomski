// Get xml template name based on current locale
String getLocalisedTemplate(String baseName){
  return baseName + "_" + Locale.getDefault().getLanguage() + ".xml";
}

public String renderPage(){
  if(currentUser.isTutor()){
    //This will be tutor_en.xml or tutor_ru.xml
    String templateFile = getLocalisedTemplate("tutor");

    //Return localised and transformed HTML
    return applyXslt("tutor.xslt", templateFile);
  } else if (currentUser.isStudent()){
    // same as above replacing tutor with student
  }
}