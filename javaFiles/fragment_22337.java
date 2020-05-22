HashMap<String, Double> colorMap = new HashMap<String, Double>();
StringTokenizer labelTok = new StringTokenizer(static_labels, ",");
StringTokenizer valuesTok = new StringTokenizer(static_xvalues, ",");
while(labelTok.hasMoreElements()){
  assert(valuesTok.hasMoreElements());
  colorMap.put(labelTok.nextElement(), Double.parseDouble(valuesTok.nextElement()));
}