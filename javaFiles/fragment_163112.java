public class Cart {

    public static void main(String[] args) {

        Scanner userin = new Scanner(System.in);
        String keepShopping;
        int quantity;
        do {
            System.out.println("What would you like to add to your cart? Enter its corresponding number");
            int choose = userin.nextInt();

            if (choose > 14) {
                System.out.println("please choose a valid option!");
            }
            System.out.println("how many?");
            quantity = userin.nextInt();

            if (choose == 1) {
                cart1.addToCart(FoodItems.QUINOA, 7.00, quantity);
            }
            else if (choose == 2) {
                cart1.addToCart(FoodItems.ORGEGG, 3.00, quantity);
            }
            else if (choose == 3) {
                cart1.addToCart(FoodItems.CCNTW, 1.00, quantity);
            }
            System.out.print("\nWould you like to add anything else to your cart (y/n)? ");
            keepShopping = userin.next();
        } while (keepShopping.equals("y"));
        if (keepShopping.equals("n")) {
            System.out.println("\n");
        }
        System.out.println("");
    }