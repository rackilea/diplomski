boolean match = false;
Iterator<List<String>> it = myList.iterator();
while (it.hasNext() && !match) {
    List<String> sublist = it.next();
    match = equalsInAnyOrder(sublist, target);
}