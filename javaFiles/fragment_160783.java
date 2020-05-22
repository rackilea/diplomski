Map<String, String> mapping = new HashMap<String, String>();  
mapping.put("nba", "sports");

String type = mapping.get("nba");

System.out.println(type);   // Will give you `sports`