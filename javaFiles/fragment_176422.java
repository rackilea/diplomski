Collections.sort(Database.arrayList, new Comparator<MyObject>() {
    @Override
    public int compare(MyObject o1, MyObject o2) {
        return o1.getStartDate().compareTo(o2.getStartDate());
    }
});