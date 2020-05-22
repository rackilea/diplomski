TreeMap<String, String> tmap = 
         new TreeMap<String, String>();
 tmap.put("1", "Data1");
  tmap.put("23", "Data2");
  tmap.put("70", "Data3");
  tmap.put("4", "Data4");
  tmap.put("2", "Data5");
// this will be like this after converting it to Json using Gson lib
// new Gson ().toJson(tmap);
{"1":"Data1","2":"Data5","23":"data2","4":"data4","70":"Data3"}