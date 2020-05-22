public class Program {

    public static void main(String[] args) {
        // Declare your scanner
        Scanner sc = new Scanner(System.in);

        // Waits the user to input a value in the console
        Integer integer = sc.nextInt();

        // Close your scanner
        sc.close();

        // Put your string into a char array
        char[] array = integer.toString().toCharArray();

        // Print the result
        System.out.println(Arrays.toString(array));
    }
}