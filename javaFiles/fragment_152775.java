String json1 = new Gson().toJson(object1); 
String json2 = new Gson().toJson(object2); 
response.setContentType("application/json"); 
response.setCharacterEncoding("utf-8"); 
String bothJson = "["+json1+","+json2+"]"; //Put both objects in an array of 2 elements
response.getWriter().write(bothJson);