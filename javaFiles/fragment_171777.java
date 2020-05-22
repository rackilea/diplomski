class A implements Comparable<A> {
    private Integer x;

    public A(Integer i) {
        x = i;
    }

    public Integer getX() {
        return getX();
    }

    protected Integer compareValue() {
        return getX();
    }

    @Override
    public int compareTo(A other) {
        return compareValue().compareTo(other.compareValue());
    }
}

class B extends A {
    Integer y;

    public B(Integer a, Integer b) {
        super(a);
        y = b;
    }

    public Integer getY() {
        return y;
    }

    @Override
    protected Integer compareValue() {
        return getX() + getY();
    }
}