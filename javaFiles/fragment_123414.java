public static Map<String, String> getQueryMap(String query)  
{  
    String[] params = query.split("&");  
    Map<String, String> map = new HashMap<String, String>();  
    for (String param : params)  
    {  
        String [] p=param.split("=");
        String name = p[0];  
        if(p.length>1)  {
            String value = p[1];  
            map.put(name, value);
        }  
    }  
    return map;  
}