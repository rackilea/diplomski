public static <T> ArrayList<T> noDups(Comparator<T> cmp, ArrayList<T> l) {

    ArrayList<T> noDups = new ArrayList<T>();
    for (T o : l) {
        if (!isAlreadyInArrayList2(cmp, o, noDups))
            noDups.add(o);
    }
    return noDups;
}