JSONArray finalArray = new JSONArray(); // create your jsonarray
 for (int i = 0; i < nodes.getLength(); i++) {
     Node node = nodes.item(i);

     if (node.getNodeType() == Node.ELEMENT_NODE) {
         Element element = (Element) node;
         //System.out.println(getValue("processName", element).contains("carkitd"));
         //if(element.getElementsByTagName("process") != null){
         if (element.getFirstChild().getNodeValue() != null) {
             if (getValue("processName", element).contains("carkitd")) {
                 JSONObject json = new JSONObject(); // your temp obj

                 json.put("processName", getValue("processName", element));
                 json.put("cpuUsage", getValue("cpuUsage", element));
                 json.put("realmemory", getValue("realmemory", element));
                 json.put("Virtualmemory", getValue("Virtualmemory", element));
                 json.put("thread", getValue("thread", element));
                 json.put("cputime", getValue("cputime", element));
                 finalArray.put(json); // push your values in the array
             }
         }

     }
 }
 //System.out.println("result-array:" +arrayvalue);
 System.out.println("result " + finalArray);