URL obj = new URL("http://mkyong.com");
    URLConnection conn = obj.openConnection();

    //get all headers
    Map<String, List<String>> map = conn.getHeaderFields();
    for (Map.Entry<String, List<String>> entry : map.entrySet()) {
        System.out.println("Key : " + entry.getKey() + 
                 " ,Value : " + entry.getValue());
    }

    //get header by 'key'
    String server = conn.getHeaderField("Server");