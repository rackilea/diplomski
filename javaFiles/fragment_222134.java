ArrayList<ArrayList<String>> listofLists = new ArrayList<ArrayList<String>>();
int length = -1;
for(String str : s) { // where s is your sorted ArrayList of Strings
    if(str.length() > length) {
        listofLists.add(new ArrayList<String>());
        length = str.length();
    }
    listofLists.get(listofLists.size()-1).add(str);
}