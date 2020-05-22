list.sort((o1, o2) -> {
    int cmp = o1.getGroup().compareTo(o2.getGroup());
    if (cmp == 0)
        cmp = Integer.compare(o1.getAge(), o2.getAge());
    if (cmp == 0)
        cmp = o1.getName().compareTo(o2.getName());
    return cmp;
});