public int compare(Object o1, Object o2) {
    Field oo1 = (Field ) o1;
    Field oo2 = (Field ) o2;

    return oo1.getFieldID().compareTo(oo2.getFieldID());
}