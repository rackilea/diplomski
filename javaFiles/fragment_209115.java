String token = request.getParameter("token").toString();
// To decode url
String decodedtoken = URLDecoder.decode(token , "UTF-8");
System.out.println("Decoded token value "+ decodedtoken);

// To encode url 
String encodedtoken = URLEncoder.encode(token , "UTF-8"); 
System.out.println("Encoded token value "+ encodedtoken);