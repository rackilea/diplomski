Vector<Vector<E>> returner = new Vector<>();
for (int i=1; i<edges.size(); i++) {
    Vector<E> insert = new Vector<>();
    insert.add(edges.firstElement());
    insert.add(edges.elementAt(i));
    returner.add(insert);
}