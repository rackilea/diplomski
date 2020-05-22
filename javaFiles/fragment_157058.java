List<String> myList = new ArrayList<String>();
... add code to populate the list with some data...
for (int i = myList.size() - 1 ; i >= 0 ; i--) {
    if (myList.get(i).equals("delete me")) {
        myList.remove(i);
    }
}