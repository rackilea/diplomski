class Example<N extends Number, D extends Double> {
    N nullAsNumber() { return null; }
    D nullAsDouble() { return null; }

    public static void main(String[] args) {
        Example<Double, Double> e = new Example<>();

        try {
            Double a = false ? 0.0 : e.nullAsNumber();
            System.out.printf("a == %f%n", a);
            Double b = false ? 0.0 : e.nullAsDouble();
            System.out.printf("b == %f%n", b);

        } catch (NullPointerException x) {
            System.out.println(x);
        }
    }
}