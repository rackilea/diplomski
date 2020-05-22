int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
String param = Arrays.toString(array);
param = param.substring(1, param.length()-1);//removing enclosing []
String encArray = URLEncoder.encode(param, "utf-8");

// Send encArray as parameter.
resp.sendRedirect(("result.jsp?fibSequence=" + encArray));