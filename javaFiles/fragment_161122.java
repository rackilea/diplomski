final static double espressoPrice = 2.00;
final static double cappuccinoPrice = 3.25;
final static double lattePrice = 3.50;
final static double coffeePrice = 1.50;

public static void main(String[] args) {

    int customersSimulated = 0;
    int maxCustomersSimulated = 4;
    int randomQuantity = 0;
    double total = 0;

    double totalCoffee = 0;
    double totalCappuccino = 0;
    double totalLatte = 0;
    double totalEspresso = 0;

    DecimalFormat df = new DecimalFormat("##.##");

    while (customersSimulated <= maxCustomersSimulated) { 

        System.out.println("Customer " + customersSimulated);    

        Random randomList = new Random();
        int randomItem = randomList.nextInt(4) + 1;   

        if (randomItem == 1) {

            System.out.println("Item purchased: Coffee");
            randomQuantity = randomList.nextInt(5) + 1;
            System.out.println("Quantity purchased: " + randomQuantity);
            double totalCoffeeCost = randomQuantity * coffeePrice;
            System.out.println("Total Cost: $" + df.format(totalCoffeeCost)); 

            totalCoffee+=totalCoffeeCost;
        } else if (randomItem == 2) {

            System.out.println("Item purchased: Latte");
            randomQuantity = randomList.nextInt(5) + 1;
            System.out.println("Quantity purchased: " + randomQuantity);
            double totalLatteCost = randomQuantity * lattePrice; 
            System.out.println("Total Cost: $" + df.format(totalLatteCost));

            totalLatte+=totalLatteCost;
        } else if (randomItem == 3) {

            System.out.println("Item purchased: Cappuccino");
            randomQuantity = randomList.nextInt(5) + 1;
            System.out.println("Quantity purchased: " + randomQuantity);
            double totalCappuccinoCost = randomQuantity * cappuccinoPrice; 
            System.out.println("Total Cost: $" + df.format(totalCappuccinoCost));

            totalCappuccino+=totalCappuccinoCost;
        } else if (randomItem == 4) {

            System.out.println("Item purchased: Espresso");
            randomQuantity = randomList.nextInt(5) + 1;
            System.out.println("Quantity purchased: " + randomQuantity);
            double totalEspressoCost = randomQuantity * espressoPrice; 
            System.out.println("Total Cost: $" + df.format(totalEspressoCost));

            totalEspresso+=totalEspressoCost;
        }

        System.out.println();
        System.out.println("Total Coffee Cost: $" + totalCoffee);
        System.out.println("Total Cappuccino Cost: $" + totalCappuccino);
        System.out.println("Total Llatte Cost: $" + totalLatte);
        System.out.println("Total Espresso Cost: $" + totalEspresso);
        System.out.println();

        customersSimulated++;
    }
}