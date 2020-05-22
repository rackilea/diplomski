public class Main {


public static void main(String[] args) {
    Scanner scan ;
    scan = new Scanner(System.in);
    System.out.println("What would you like to add");
    int n1 = scan.nextInt();
    System.out.println( "You have selected" + n1);
    int n2 = scan.nextInt();
    System.out.println( "You have selected" + n2);
    int calculation= n1+n2;
    System.out.println("Calculation=" + calculation);
}