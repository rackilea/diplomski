interface MyInterface<T extends Number> {
    T getVal();
}
class DoubleImpl implements MyInterface<Double> {
    public Double getVal() {return 42.42; }
}
...
public static void main (String[] args) throws java.lang.Exception {
    MyInterface<? extends Number> x = new DoubleImpl();
    Type[] ifs = x.getClass().getGenericInterfaces();

    System.out.println(ifs.length);
    for (Type c : ifs) {
        System.out.println(c);
        Type[] tps = ((ParameterizedType)c).getActualTypeArguments();
        for (Object tp : tps) {
            System.out.println("===="+tp); // <<== This produces class java.lang.Double
        }
    }
}