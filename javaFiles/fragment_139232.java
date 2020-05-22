int s = 32343;
ArrayList<Integer> al = new ArrayList<Integer>(s);
for (int c = 0; c < s; c++) {
    al.add(c);
}
Iterator<Integer> it = al.iterator();
if (it.hasNext()) {
    int c = it.next();
    c = c++;
}