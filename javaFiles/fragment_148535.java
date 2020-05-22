public String appendCSV(Map featureset) throws IOException{
  StringBuilder csvReport = new StringBuilder(); 

  Map<String, Integer> map =featureset;
  Set<String> keys = map.keySet();

  String[] lsitofkeys = {};
  boolean isFirst=true;
  for(String elements : keys){
     if(!isFirst){
       csvReport.append(",");
     }
     csvReport.append(elements);
     isFirst=false;
  }

  csvReport.append("\n");

  isFirst=true;
  for(String elements : keys){
     if(!isFirst){
       csvReport.append(",");
     }
   csvReport.append(map.get(elements));
   isFirst=false;
  }

  return csvReport.toString();
}