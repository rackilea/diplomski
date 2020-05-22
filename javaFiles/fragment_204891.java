// you can sort only Collections so let's say you want to sort values
Collections.sort(mapValues, new Comparator<MyClass> () {
    @Ovveride
    public int compareTo(MyClass c1, MyClass c2) {
       return c1.compare(c2);
    }
});