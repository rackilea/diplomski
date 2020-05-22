public class Example {

    private Number a;

    public Number getA() {
        return a;
    }

    public void setA(Double a) {
        if (a % 1 == 0) {
            this.a = a.intValue();
        } else {
            this.a = a;
        }
    }

    public void setA(int a) {
        this.a = a;
    }

    public static void main(String[] args) {
        double integerNumber = 6;

        Example example = new Example();
        example.setA(integerNumber);
        System.out.println(example.getA());
    }

}