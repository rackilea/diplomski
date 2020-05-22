Map<String, String> replacements = new HashMap<String, String>();
replacements.put("paramesh", "venky");
replacements.put("ramesh", "mahesh");
replacements.put("suresh", "fine");

String constantString="paramesh,ramesh,suresh";

for(Map.Entry<String,String> entry : replacements.entrySet()){
  constantString = constantString.replaceAll("\\b" + Pattern.quote(entry.getKey()) + "\\b", 
                                             entry.getValue());
}