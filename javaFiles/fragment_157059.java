ListIterator<String> listIter = myList.listIterator();
while (listIter.hasNext()) {
    if (listIter.next().equals("delete me")) {
        listIter.remove();
    }
}