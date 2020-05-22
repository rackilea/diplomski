public static void main(String[] args) {  
    double temperature;  
    Scanner in = new Scanner(System.in);  
    System.out.printf("Enter Fahrenheit Temperature: "); 

    // As long as it is not a double ask for another input
    while (!in.hasNextDouble()) {
        System.out.printf("Please enter a valid number:");
        in.next(); 
    }
    temperature = in.nextDouble();
    temperature = (temperature - 32) * 5 / 9;  

    // Use only 2 decimals
    int round = (int) Math.round(temperature*100);
    temperature = round / 100.0;

    System.out.printf("Censius Temperatre is  = " + temperature);  
 }