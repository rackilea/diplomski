String s = "<html><div style=\"text-align:center;\"><b>first</b><br><i>Aula: </i><b>second</b></div></html>";
int start = s.indexOf("<b>");
int end = s.indexOf("</b>");
String firstMatch = s.substring(start + "<b>".length(), end);

//now we can start looking for next `<b>` after position where we found `</b>`
start = s.indexOf("<b>", end);
//and look for </b> after position that we found latest <b>
end = s.indexOf("</b>", start);
String secondMatch = s.substring(start + "<b>".length(), end);

System.out.println(firstMatch);
System.out.println(secondMatch);