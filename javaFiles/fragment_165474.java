Comparator<Boo> booCmp = new Comparator<Boo>() {
    @Override
    public int compare(Boo o1, Boo o2) {
        int cmp = o1.propertyX.compareTo(o2.propertyX);
        if (cmp == 0)
            cmp = o1.propertyY.compareTo(o2.propertyY);
        if (cmp == 0)
            cmp = o1.propertyZ.compareTo(o2.propertyZ);
        return cmp;
    }
};