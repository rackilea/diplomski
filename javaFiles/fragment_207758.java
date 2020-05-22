URL obj = new URL("http://localhost:8080/SpringSecurity/admin");          
URLConnection conn = obj.openConnection();

//get all response headers
Map<String, List<String>> map = conn.getHeaderFields();
for (Map.Entry<String, List<String>> entry : map.entrySet()) {
    System.out.println("Key : " + entry.getKey() + " ,Value : " + entry.getValue());
}

//get response body
InputStream output = conn.getInputStream();
Scanner s = new Scanner(output).useDelimiter("\\A");
String result = s.hasNext() ? s.next() : "";
System.out.println(result);