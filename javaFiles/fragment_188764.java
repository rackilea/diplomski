String[] names = request.getParameterValues("metric_name");
String[] values = request.getParameterValues("metric_value");
for (int i = 0; i < names.length; i++) {
         System.out.print("<tr><td>" + names[i] + "</td>\n");
         System.out.println("<td> " + valuse[i] + "</td></tr>\n");
     }