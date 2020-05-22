Map<String, List<String> > vars  = new HashMap<String, List<String>>();

for(int i=0; i<nameList.size(); i++){

   String key = nameList.get(i);
   List<String> value = new ArrayList<String>();
   vars.put(key, value);
}