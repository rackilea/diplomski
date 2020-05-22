public int compare(MyModelClass o1, MyModelClass o2) {
    Integer id1= o1.getId();
    Integer id2= o2.getId();
    if (id1 == null) {
        return id2 == null ? 0 : 1;
    }

    return id2 == null ? -1 : id1.compareTo(id2);
}