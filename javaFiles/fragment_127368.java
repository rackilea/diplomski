public E[] toArray()
    {
        List<E> lista = new ArrayList<E>();
        toArray(root, lista);
        E[] arr = (E[]) new Comparable[numElements];
        lista.toArray(arr);
        return arr;
    }