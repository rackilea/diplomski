boolean exist = false;
ListIterator<e> iterator = listClosestFirst.listIterator(0);

while (iterator.hasNext() && !exist) {
    exist = (e.getLocation()).equals((iterator.next()).getLocation());
}

if (!exist) {
    listClosestFirst.add(e);
}