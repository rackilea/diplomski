for (Iterator<Integer> i = set.iterator(); i.hasNext();) {
    Integer element = i.next();
    if (element % 2 == 0) {
        i.remove();
    }
}