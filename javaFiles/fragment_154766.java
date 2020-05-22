private static <E extends Comparable<E>> List <E> DominioAux(List<E> lista, E a, E b,Integer i, Integer j){
    List<E> res = new ArrayList<>();

    if(i >= j) { //Check if the value of list[i] is in the range [a,b)
        if (lista.get(i).compareTo(a) >= 0 && lista.get(i).compareTo(b) < 0) {
            res.add(lista.get(i));
        }

        return res;
    }

    Integer m = (i + j) / 2;
    List<E> list1 = DominioAux(lista, a, b, i, m);
    List<E> list2 = DominioAux(lista, a, b, m + 1, j);

    res.addAll(list1);
    res.addAll(list2);

    return res;
}