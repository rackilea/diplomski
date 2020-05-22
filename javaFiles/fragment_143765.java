while (newFile.hasNext()) {
  String s = newFile.next();
  int ind = s.indexOf(":");
  if(ind != -1){
    String value = s.substring(ind); //value is what you want
  }
}