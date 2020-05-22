public ListOfLists(int noOfLists) {
    this.noOfLists = noOfLists;
    for (int i = 0; i < noOfLists; i++) {
        mainList.add(new ArrayList<>());
    }
}