List<List<String>> list1 = new ArrayList<List<String>>();

for(some loop) {
    List<String> list2 = new ArrayList<String>();
    // populate list2, can be smaller than the previous list2 !!
    list1.add(list2);
}