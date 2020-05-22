public void extendsExample(){
  Set<? extends List<? extends String>> setOfList = new HashSet<>();
  Set<ArrayList<String>> setOfArrayList = new HashSet<>();

  // now setOfList var refers to a set 
  // which contains a arraylist of String
  setOfList = setOfArrayList;

  // compilation fails
  setOfList.add(new LinkedList<String>());
 }