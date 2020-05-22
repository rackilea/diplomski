private static void printTemperature(int[] temperature) {
    System.out.print("The temperatures in increasing order are: ");
     for(int i=0; i<temperature.length; i++){
        System.out.print(temperature[i]+" ");
     }
}

private static void readTemperatures(Scanner keyboard, int[] temperature){
       System.out.println("Enter number of days of temperature to calculate:");
       int day = keyboard.nextInt();
       temperature = new int[day];
       System.out.println("Enter " + day + " temperatures to calculate.");
       for(int i=0; i<day; i++){
        temperature[i] = keyboard.nextInt();
       }
}