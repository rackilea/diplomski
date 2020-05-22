String test =  "<table>Normal table</table><table>   <--- I want to get this table<tr>" +
               "<td><div>...</div></td></tr>...</table>";

Pattern pattern = Pattern.compile("<table>(?=(?:(?!</table>)[\\s\\S])*?<div>)[\\s\\S]*?</table>");
Matcher matcher = pattern.matcher(test);
if( matcher.find())
    System.out.println("Teste " + matcher.group());