public class Main {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            measurementIteration();
        }
    }

    public static void measurementIteration() {
        long s, t1 = 0, t2 = 0;
        float mFloat = 3.3f;
        int f, n1 = 0, n2 = 0;
        for (int i = 0; i < 1E4; i++) {
            switch ((int) (Math.random() * 2)) {
            case 0:
                n1 += 1E4;
                s = System.currentTimeMillis();
                for (int k = 0; k < 1E4; k++)
                    f = (int) (mFloat + 0.5);
                t1 += System.currentTimeMillis() - s;
                break;
            case 1:
                n2 += 1E4;
                s = System.currentTimeMillis();
                for (int k = 0; k < 1E4; k++)
                    f = Math.round(mFloat);
                t2 += System.currentTimeMillis() - s;
                break;
            }
        }
        System.out.println(String.format("(int) (mFloat + 0.5): n1 = %d    -> %.3fms/1000", n1, t1 * 1000.0 / n1));
        System.out.println(String.format("Math.round(mFloat)  : n2 = %d    -> %.3fms/1000", n2, t2 * 1000.0 / n2));
    }
}