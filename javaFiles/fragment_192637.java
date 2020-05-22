public class A extends Base {
    private double[] value;

    public A() {
        type = "A";
    }

    public A(double[] value) {
        this();
        setValue(value);
    }

    public double[] getValue() {
        return value;
    }

    public void setValue(double[] value) {
        this.value = value;
    }
}

public class B extends Base {

    private List<A> value = new ArrayList<A>();

    public B() {
        type = "B";
    }

    public B(List<A> value) {
        this();
        setValue(value);
    }

    @JsonIgnoreProperties({"type"})
    public List<A> getValue() {
        return value;
    }

    @JsonGetter("value")
    @JsonIgnoreProperties({"type"})
    public List<double[]> getA() {
        List<double[]> res = new ArrayList<>();
        for (A a : value) {
            res.add(a.getValue());
        }
        return res;
    }

    public void setValue(List<A> value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "" + value;
    }
}

public class C extends Base {
    private List<B> value = new ArrayList<B>();

    public C() {
        type = "C";
    }

    @JsonGetter("value")
    @JsonIgnoreProperties({"type"})
    public List<List<double[]>> getB() {
        List<List<double[]>> res1 = new ArrayList<>();            
        for (B b : value) {
            List<double[]> res2 = new ArrayList<>();
            for (A a : b.getValue()) {
                res2.add(a.getValue());
            }
            res1.add(res2);
        }
        return res1;
    }

    public List<B> getValue() {
        return value;
    }

    public void setValue(List<B> value) {
        this.value = value;
    }
}