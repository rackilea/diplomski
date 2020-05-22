public static void main (String[] args)  {

    int num = countGreaterThan(new Integer[] {25,14,48,86}, 20);
}


public static <T extends Comparable<T>> int countGreaterThan(T[] anArray, T elem) {
    int count = 0;
    for (T e : anArray)
        if (e.compareTo(elem) > 0)
            ++count;
    return count;
}