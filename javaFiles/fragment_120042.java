public MyArrayList extends ArrayList<MyClass> {

    @Override
    public boolean equals(Object o) {
        if (o instanceof MyArrayList) {
            //place your comparison logic here
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        //just a sample, you can place your own code
        return super.hashCode();
    }
}