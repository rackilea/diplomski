public class Marks {

/**
 * @param args the command line arguments
 */
public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    int[] array = new int[23];
    int num = 0;
    int count = 0;
    int total = 1;

    System.out.println ("Enter students marks in the range 0 to 100\n");

        loop: for (count = 0; count <= 20; count++) {
            System.out.println("Enter a number:");
            num = scan.nextInt();
            if (num < 0 || num > 100) {
                break loop;

            }
            array[count] = num;
            total = count+1;
        }
    System.out.println ("How many times a number between 0-100 occur.");

    String[] asterisk = {"0- 29   | ", "30- 39  | ","40- 69  | ", "70- 100 | "}; //4 strings

    for (count = 1; count <= total; count++)
    {
        num=array[count];
        if (num >=0 && num<=29) asterisk [0] +="*";
        else if (num>29 && num<=39) asterisk[1] +="*";
        else if (num>39 && num <=69) asterisk[2] +="*";
        else if (num >69 && num <=100) asterisk[3] +="*";
    }
    for (count =0;count < 4;count++)
        System.out.println(asterisk[count]);
    System.out.println("The total amount of students is " + total);
}
}