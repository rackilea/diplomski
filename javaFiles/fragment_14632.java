Collections.sort(marks);
int row = 0;
ListIterator li = a.listIterator(a.size());
while(li.hasPrevious()) {
    System.out.println(li.previous());
}