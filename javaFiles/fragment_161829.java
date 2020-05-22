public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
    int choice; 
    double total = 0;

    //Array for storing prices
    double [] cafePrice = new double[5];
    cafePrice[0]= 6.99;
    cafePrice[1]= 5.99;
    cafePrice[2]= 2.99;
    cafePrice[3]= 1.50;
    cafePrice[4]= 2.50;

    //Menu item array
    String [] cafeDrink = new String[5];
    cafeDrink[0] = "Macchiato";
    cafeDrink[1] = "Latte"; 
    cafeDrink[2] = "Americano";
    cafeDrink[3] = "Tea";
    cafeDrink[4] = "Cappichino";

    //Welcome user and gather their menu selection
    System.out.println("Welcome to our cafe! Please enjoy!");
    System.out.printf("The average pricing for our drinks is: %.2f \n", + cafeAvg( cafePrice));
    System.out.println("Please enter a menu selection:\n"
            + "0. Macchiato -- $6.99\n"
            + "1. Latte -- $5.99\n"
            + "2. Americano -- $2.99\n"
            + "3. Tea -- $1.50\n"
            + "4. Cappichino -- $2.50");
    choice = input.nextInt();

    //Add up the total
    total += cafePrice[choice];
    System.out.println("Your total is: " + total);
    }

    //Method for average menu price
public static double cafeAvg(double[] array) {
    double sum = 0;
    double sum2 = 0;
    for(int i = 0; i < array.length; i++) {
        sum += array[i];
        sum2 = sum /array.length;
    }
    return sum2;
}