public <T extends Number & Comparable<T>> ArrayList<T> sortDescending(ArrayList<T> al){
    Comparator<T> c=Collections.reverseOrder();
    Collections.sort(al,c);
    return al;
}

public <T extends Number & Comparable<T>> ArrayList<T> sortAscending(ArrayList<T> al){
    Collections.sort(al);
    return al;
}