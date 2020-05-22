1218    public static <T> void More ...sort(T[] a, Comparator<? super T> c)   {
1219        T[] aux = (T[])a.clone();
1220        if (c==null)
1221            mergeSort(aux, a, 0, a.length, 0);
1222        else
1223            mergeSort(aux, a, 0, a.length, 0, c);
1224    }