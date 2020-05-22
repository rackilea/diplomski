public class Math {
    public static void main(String[] args) {
        // Program starts here

        // Show and calculate math results here
        System.out.println("Math.pow(3.0, 2.0) = " + Math.pow(3.0, 2.0));
        // ...

        // This will execute the randomStudy method.
        randomStudy();
    }

    public void randomStudy() {
        // randomStudy method code goes here
        int min = 11;
        int max = -1;
        int total = 0;

        for(int i = 0; i < 1000; i++) {
            int randomInt = (int)(11.0 * Math.random());

            System.out.println("Random integer between 1 and 10: " + randomInt);

            int newtotal = (randomInt + total);

            if (newtotal < min) {
                min = Math.random());
            } else {
                System.out.println("Min: " + min);
            }

            if (newtotal > max) {
                max = Math.random());
            } else {
                System.out.println("Max: " + max);
            }
         }

         System.out.println("Min value:" + min);
         System.out.println("Max Value:" + max);
         System.out.println("Average:"+ newtotal / 1000d);
    }
}