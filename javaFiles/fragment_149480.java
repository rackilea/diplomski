public List<NumberList> CreateObject(List<String[]> ReadFile){
  ArrayList<NumberList> returnList = new ArrayList<NumberList>(ReadFile.size());
  for (String[] input : ReadFile) {
    returnList.add(new NumberList(input));
  }
  return returnList;
}