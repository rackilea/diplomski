final int numberOfCars = 5;
Scanner userInput = new Scanner(System.in);   
String[] cars = new String[numberOfCars];

for (int i = 0; i < numberOfCars; i++) {
    cars[i] = userInput.nextLine();
}