public class MyTest {

    private static double START = 0;
    private static double END = 100;
    private static double INCREMENT = 0.0001;

    @Test
    public void testFirst() throws Exception {
        long time = System.nanoTime();
        for (double bMI = START; bMI < END; bMI += INCREMENT) {
            first(bMI);
        }
        System.out.println("First  " + (System.nanoTime() - time));
    }

    @Test
    public void testSecond() throws Exception {
        long time = System.nanoTime();
        for (double bMI = START; bMI < END; bMI += INCREMENT) {
            second(bMI);
        }
        System.out.println("Second " + (System.nanoTime() - time));
    }

    private String first(double bMI) {
        String weightStatus = "Underweight";
        if (bMI > 29.9) {
            weightStatus = "Obese";
        } else if (bMI >= 25.0) {
            weightStatus = "Overweight";
        } else if (bMI >= 18.5) {
            weightStatus = "Healthy Weight";
        }
        return weightStatus;
    }

    private String second(double bMI) {
        String weightStatus;
        if (bMI > 29.9) {
            weightStatus = "Obese";
        } else if (bMI >= 25.0) {
            weightStatus = "Overweight";
        } else if (bMI >= 18.5) {
            weightStatus = "Healthy Weight";
        } else {
            weightStatus = "Underweight";
        }
        return weightStatus;
    }
}