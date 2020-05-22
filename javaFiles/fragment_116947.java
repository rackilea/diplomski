List<String> listOne = new ArrayList<String>();
//add elements
List<String> listTwo= new ArrayList<String>();
//add elements
List<String> commonList = new ArrayList<String>(listTwo);
commonList.retainAll(listOne);
int commonListSize = commonList.size();