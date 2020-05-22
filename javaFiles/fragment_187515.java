public class IntegerArray {
    public static void main(String[] args) {
        // set up the constant for the size of the array
        final int MAX = 10;
        int sum = 0;
        int average = 0;

        int[] randomArray = new int[MAX];

        for (int index = 0; index < MAX; index++)

            // values of the array go from 0-10
            randomArray[index] = (int) (Math.random() * 10);

        // prints the array
        for (int value : randomArray)
            System.out.println(value);


        System.out.println("The length of the array is: " + randomArray.length);

        Driver driver = new Driver();
        System.out.println(driver.getAverage());
    }
}