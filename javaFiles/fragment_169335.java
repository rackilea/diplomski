static void quickSort(Integer[] ar) {

    ArrayList<Integer> left = new ArrayList<Integer>();
    ArrayList<Integer> equal = new ArrayList<Integer>();
    ArrayList<Integer> right = new ArrayList<Integer>();
    int num = ar[0];
    for (int i = 0; i < ar.length; i++) {
        if (ar[i] < num) {
            left.add(ar[i]);
        } else if (ar[i] > num) {
            right.add(ar[i]);
        } else {
            equal.add(ar[i]);
        }
    }
    Integer[] l = new Integer[0];
    l = left.toArray(l);
    Integer[] e = new Integer[0];
    e = equal.toArray(e);
    Integer[] r = new Integer[0];
    r = right.toArray(r);
    if (l.length > 1) {
        quickSort(l);
    }

    if (r.length > 1) {
        quickSort(r);
    }
    ArrayList<Integer> combined = new ArrayList<Integer>();
    for(int ai = 0; ai < l.length; ai++)
    {
        combined.add(l[ai]);
    }
    for(int ai = 0; ai < e.length; ai++)
    {
        combined.add(e[ai]);
    }
    for(int ai = 0; ai < r.length; ai++)
    {
        combined.add(r[ai]);
    }
    combined.toArray(ar);
    //printArray(ar);
    System.out.println(combined);
}