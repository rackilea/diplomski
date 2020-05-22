class A {

    int i;

    // other fields

    public A(int i) {
       this.i = i;
    }  
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        A a = (A) o;

        return i == a.i;

    }

    @Override
    public int hashCode() {
        return i;
    }
}

List<A> list = new ArrayList<>();
list.indexOf(new A(3));