interface P {

    public String getValue();
}

class PA implements P {

    private final A a;

    PA(A a) {
        this.a = a;
    }

    @Override
    public String getValue() {
        return a.getSomething();
    }
}

class PB implements P {

    private final B b;

    PB(B b) {
        this.b = b;
    }

    @Override
    public String getValue() {
        return b.getSomethingElse();
    }
}

class PC implements Comparator<P> {

    @Override
    public int compare(P o1, P o2) {
        return o1.getValue().compareTo(o2.getValue());
    }

}