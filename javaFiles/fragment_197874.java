public void removeIntArray(List list, int[] toRemove) {
    ListIterator listIterator = list.listIterator();
    while (listIterator.hasNext()) {
        Object object = listIterator.next();
        if (object instanceof int[]) {
            int[] ints = (int[]) object;
            if (Arrays.equals(ints, toRemove)) {
                listIterator.remove();
                break;
            }
        }
    }
}