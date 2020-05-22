Collections.sort(myList, new Comparator<MyObject>() {
    @Override
    public int compare(MyObject a, MyObject b) {
        int cmp0 = a.getAttributeX().compareTo(b.getAttributeX());
        if (cmp0 != 0) {
            return cmp0;
        }
        int cmp1 = a.getSomething().getSubValue().compareTo(b.getSomething().getSubValue());
        if (cmp1 != 0) {
            return cmp1;
        }
        return a.getInt() - b.getInt();
    }
});