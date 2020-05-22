URl u = new URL("myurl.com/file.ext?Param1=value&param2=value2&param3=value3");
Map<String, String> params = getQueryMap(u.getQuery());

public static Map<String, String> getQueryMap(String query)  
{  
    String[] params = query.split("&");  
    Map<String, String> map = new HashMap<String, String>();  
    for (String param : params)  
    {  
        String[] parts = param.split("=");
        String name = parts[0];  
        String value = parts[1];  
        map.put(name, value);  
    }  
    return map;  
}