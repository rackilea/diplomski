public class MainClass {

//Main Method
public static void main(String[] args) {

    //Variables
    char avg;
    int i;

    Scanner scan = new Scanner(System.in);
    System.out.print("How many grades do you want to enter: ");
    int grades = scan.nextInt();
    int array[] = new int[grades];

    for (i = 0; i < grades; i++) {
        System.out.print("Enter grade " + (i + 1) + ": ");
        array[i] = scan.nextInt();
    }


    avg = average(array);
    System.out.println("The class average for the test is: " + avg);
}

private static char average(int[] array) {
    final int sum = Arrays.stream(array).sum();
    final int b = sum / array.length;

    if (b >= 90) {
        return 'A';
    } else if (b <= 90 && b >= 80) {
        return 'B';
    } else if (b <= 80 && b >= 70) {
        return 'C';
    } else if (b <= 70 && b >= 60) {
        return 'D';
    } else if (b <= 60) {
        return 'F';
    } else {
        return '?';
    }

} }