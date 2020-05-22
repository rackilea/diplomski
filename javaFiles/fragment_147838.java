JSONArray msg = (JSONArray) jsonObject.get("tag2");    
 Iterator<JSONArray> iterator = msg.iterator();

 while (iterator.hasNext()) {
        Iterator<String> innerIterator = iterator.next().iterator();
        while (innerIterator.hasNext()) {
             String text = innerIterator.next();    
             System.out.println(text);
        }
 }