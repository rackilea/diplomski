public class Pair {
        private final double a;
        private final double b;

        public Pair(double a, double b){
            this.a = a;
            this.b = b;
        }

        public double calculateWith(BinaryCalculator calculator){
            return calculator.addition(a,b);
        }
    }