import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        HashMap<String, Double> menu = new HashMap<String, Double>();
        Scanner Obj = new Scanner(System.in);
        Scanner Obj2 = new Scanner(System.in);

        menu.put("Cheese Burger", 1.99);
        menu.put("Kebab Wrap", 4.99);
        menu.put("Mayo Chicken", 0.99);
        menu.put("Lamb Doner", 3.99);
        menu.put("Biscuits", 1.99);
        menu.put("Ice Cream", 1.49);
        menu.put("Chicken Burger", 3.99);
        menu.put("BBQ Chicken Burger", 3.49);
        menu.put("Zinger Burger", 2.99);

        HashMap<String, Integer> order = new HashMap<>();

        System.out.println("Write STOP to stop the program. Otherwise, press enter");
        String question = Obj.nextLine();
        while (!question.equals("END")) {

            System.out.println("Press 1 to buy an item");
            System.out.println("Press 2 to clear the price and list");
            System.out.println("Press 3 to display all the items with the price");
            int number = Obj.nextInt();
            switch (number) {
                case 1:
                    System.out.println("Please name an item: ");
                    String item = Obj2.nextLine();

                    if (menu.containsKey(item)) {

                        Integer quanity = order.get(item);
                        if (quanity == null) {
                            quanity = 0;
                        }
                        quanity++;
                        order.put(item, quanity);

                    }
                    break;
                case 2:
                    order.clear();
                    System.out.println("The list has now been cleared");
                case 3:

                    double tally = 0;
                    for (Map.Entry<String, Integer> enrty : order.entrySet()) {
                        String name = enrty.getKey();
                        int quantity = enrty.getValue();
                        double price = menu.get(name);
                        double total = quantity * price;
                        tally += total;

                        System.out.println(quantity + "x " + name + " @ " + price + " = " + total);
                    }
                    break;

            }
            System.out.println("Write STOP to stop the program. Otherwise, press enter");
            question = Obj.nextLine();
        }

    }
}