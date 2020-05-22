public void superExample(){
  Set<? super ArrayList<String>> setOfArrayList = new HashSet<>();

  // compilation ok
  setOfArrayList.add(new ArrayList<String>());
  // new anonymous type derivating from ArrayList
  ArrayList<String> derivedArrayList = new ArrayList<String>(){
  };
  // compilation ok
  setOfArrayList.add(derivedArrayList);
}