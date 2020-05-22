public String transformURLIntoLinks(String text){
String urlValidationRegex = "(https?|ftp)://(www\\d?|[a-zA-Z0-9]+)?.[a-zA-Z0-9-]+(\\:|.)([a-zA-Z0-9.]+|(\\d+)?)([/?:].*)?";
Pattern p = Pattern.compile(urlValidationRegex);
Matcher m = p.matcher(text);
StringBuffer sb = new StringBuffer();
while(m.find()){
    String found =m.group(0); 
    m.appendReplacement(sb, "<a href='"+found+"'>"+found+"</a>"); 
}
m.appendTail(sb);
return sb.toString();
   }