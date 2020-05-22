abstract class Functor {


    public abstract double compute(double a, double b);

    public static void main(String[] args) {
        Functor add = new Functor() {
            // defining it here is essentially how you do a function pointer
            public double compute(double a, double b) { return a + b; }
        };

        Functor subtract = new Functor() {
            public double compute(double a, double b) { return a - b; }
        };

        System.out.println(add.compute(1.0,2.0));
        System.out.println(subtract.compute(1.0,2.0));

    }

}