import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyClient {

    public static void main(String args[]) {

        List<Item> inventory = new ArrayList<Item>();

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s1 = sc.nextLine();

            if (s1.equals("*")) {
                break;
            } else {
                Scanner ls = new Scanner(s1);
                while (ls.hasNext()) {
                    Item item = new Item(ls.next(), ls.nextFloat(), ls.nextInt());
                    inventory.add(item);
                }

            }
        }
        System.out.println(inventory);

    }
}