static <T> ArrayList<T> qsAlgorithm(ArrayList<T> a, Comparator<? super T> comp) {

    ArrayList<T> L = new ArrayList<T>();
    ArrayList<T> E = new ArrayList<T>();
    ArrayList<T> G = new ArrayList<T>();

    if (a.size() <= 1) 
        return a;
    int pivot = (int)Math.random() * a.size();
    T pivotValue = a.get(pivot);
    for (int i = 0; i < a.size(); i++) {
        int v = comp.compare(a.get(i), pivotValue);
        if (v == -1) {
            L.add(a.get(i));
        } else if (v == 0) {
            E.add(a.get(i));
        } else {
            G.add(a.get(i));
        }
    }

    L = qsAlgorithm(L, comp);
    G = qsAlgorithm(G, comp);
    L.addAll(E);
    L.addAll(G);

    return L;

}