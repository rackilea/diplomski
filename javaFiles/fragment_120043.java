public MyArrayList<T> extends ArrayList<T> {
    //overrides the methods you need
    @Override
    public boolean equals(Object o) {
        if (o instanceof MyArrayList) {
            //place your comparison logic here
            return true;
        }
        return false;
    }
}