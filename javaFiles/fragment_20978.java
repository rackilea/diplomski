public static void main(String[] args){
    Scanner keyboard = new Scanner(System.in);

    System.out.println("What is the size of your pizza in inches?");
    double diameter = keyboard.nextDouble();
    System.out.println(area(diameter) + " square inches");
    double price = keyboard.nextDouble();
    System.out.println("What is the price of your pizza?");
    System.out.println(ppsi(diameter, price));
}

public static double area(double diameter){
    //Scanner keyboard = new Scanner(System.in);
    //double diameter = keyboard.nextDouble();
    return (diameter / 2) * (diameter / 2) * Math.PI;

}
public static double ppsi(double diameter, double price){
    //Scanner keyboard = new Scanner(System.in);
    //double price = keyboard.nextDouble();
    return((area(diameter)) / price);
}