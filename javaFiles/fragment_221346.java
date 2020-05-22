public class Test {

        public static void main(String[] args) {
            String params[][] = { { "3.3", "4.4", "5.5" }, { "5.5", "3.3", "4.4" }, { "4.4", "5.5", "3.3" } };
            for (int i = 0; i < params[0].length; i++) {
                System.out.format("%d: %s, %s, %s => ", i, params[i][0], params[i][1], params[i][2]);
                Predictor.main(params[i]);
            }
        }

        static class Predictor {

            // Simplistic example taking 3 values and returning the index of the largest.
            public static int predict(double[] atts) {
                double highestLikeli = Double.NEGATIVE_INFINITY;
                int classIndex = -1;
                for (int i = 0; i < atts.length; i++) {
                    if (atts[i] > highestLikeli) {
                        highestLikeli = atts[i];
                        classIndex = i;
                    }
                }
                return classIndex;
            }

            public static void main(String[] args) {
                if (args.length == 3) {
                    double[] atts = new double[args.length];
                    for (int i = 0; i&ltargs.length; i++) {
                        atts[i] = Double.parseDouble(args[i]);
                    }
                    System.out.println(Predictor.predict(atts));
                }
            }
        }
    }