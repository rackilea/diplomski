public String[] getResultTypeCount() {
     List<String> list = new ArrayList<String>();
     for (Map.Entry<String, Integer> entry : typeMap.entrySet()) {
         list.add(entry.getKey() + " => " + entry.getValue());
     }
     return list.toArray(new String[list.size()]);
}