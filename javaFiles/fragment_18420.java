String projectsToHtmlOptions(String projectNames,String separator){
   StringBuilder sb = new StringBuilder();
   sb.append("<select>");
   for(String project:projectNames.split(separator)
      sb.append("<option value=\""+project+"\">"+project+"</option>");
   sb.append("</select>");
   return sb.toString();
}