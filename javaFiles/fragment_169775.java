public class Name{
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println( "Enter Your Input ");
    while (scanner.hasNext()) 
    { 
        if (scanner.hasNextInt()) {
            System.out.println(" Your Value (Int) : " + scanner.nextInt());
        } else if (scanner.hasNextFloat()) {
            System.out.println(" Your Value (Float) " + scanner.nextFloat());
        } 
        else {
            System.out.println( " String Value(String) " + scanner.next());
        }
    }
}
}