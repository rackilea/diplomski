public static void change(ArrayList<Integer> inner) { // a new reference inner is created.
    //inner starts out as @1234
    inner.add(7);
    //now inner becomes @5678
    inner = new ArrayList<Integer>();
    //The object @5678 is changed.
    inner.add(23);
    //And printed.
    System.out.println(inner);
}