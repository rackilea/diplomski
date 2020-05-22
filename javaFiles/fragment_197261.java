public class Job8 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int usernumbers[] = new int[20];
        int size = usernumbers.length;

        System.out.println("Enter integers between 1 and 100, " + "enter a 0 to end ");

        // user populates the array usernumbers
        int i = 0;
        do {
            usernumbers[i] = input.nextInt();
        } while (usernumbers[i++] != 0);

        // invokes the method to sort the array
        arraySort(usernumbers);

        System.out.println(java.util.Arrays.toString(usernumbers));

        // this invokes the method to search the array for the numbers
        linearSearch(usernumbers);

        input.close();
    }

    public static void arraySort(int[] usernumbers) {
        // bubblesort for usernumbers[]
        int a = usernumbers.length;
        for (int i = 0; i < a - 1; i++) {
            for (int j = 0; j < a - i - 1; j++) {

                if (usernumbers[j] > usernumbers[j + 1]) {
                    int temp = usernumbers[j];
                    usernumbers[j] = usernumbers[j + 1];
                    usernumbers[j + 1] = temp;
                }
            }
        }
    }

    public static void linearSearch(int[] usernumbers) {
        int count = 0;
        int currentNumber = 0;
        for (int i = 0; i < usernumbers.length; i++) {
            int nextIndex = i + 1;
            currentNumber = usernumbers[i];

            if (currentNumber == 0) {
                continue;
            }

            if (nextIndex < usernumbers.length) {
                int nextNumber = usernumbers[nextIndex];
                if (currentNumber == nextNumber) {
                    count++;
                    continue;
                } else {
                    if (count == 0) {
                        System.out.println(currentNumber + " occurs once");
                    } else {
                        System.out.println(currentNumber + " occurs " + count + " times");
                        count = 0;
                    }
                }
            }
        }

        System.out.println(+currentNumber + " occurs " + (count + 1) + " times");
    }
}