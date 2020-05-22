public class AddOrMultiplyNNumbers {

public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    String am;

    while (true) {

        int sum = 0;
        int total = 1;
        int n = 0;

        System.out.print("enter an integer number: ");
        n = input.nextInt();
        if(n == 0) {
            break; 
        }
        System.out.print("enter either 'a' or 'm': ");
        input.nextLine();
        am = input.nextLine();
        if (am.equals("a")) {
            for (int y = 1; y <= n; y++) {
                sum = sum + y;
            }
            System.out.println(sum);
        } else if (am.equals("m")) {
            for (int x = 1; x <= n; x++) {
                total = total * x;
            }
            System.out.println(total);
        }
      }
   }
}