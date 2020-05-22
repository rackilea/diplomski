List<List<C>> result = new ArrayList<>();

outerloop:
for(List<C> list1 : listOfLists) {
    for(List<C> list2 : listOfLists) {
        if(list1 != list2) {
            if(list2.containsAll(list1)) {
                continue outerloop; // list1 is a sub-list of list2, continue without adding
            }
        }
    }
    result.add(list1); // only adds if list1 is not contained by any other list.
}