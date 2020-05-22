Scanner userInput = new Scanner(System.in);

//Two array's where i'll store the coordinates 
double[] coord1 = new double[3];
double[] coord2 = new double[3];

//Array for user commands
String[] commands = { "random", "exit", "help"};

System.out.println("Enter Coordinates: ");
String input = userInput.nextLine();
int arrayIndex = 0;
while (!input.equals("exit")) {

    //convert input to a double
    System.out.println("Enter Coordinates: ");
    double userDouble = Double.parseDouble(input);

    //handle case where array needs to be resized
    if (arrayIndex >= coord1.length) {
        double[] newCoord1 = new double[coord1.length * 2];
        for (int copyIndex = 0; copyIndex < coord1.length; copyIndex++) {
            newCoord1[copyIndex] = coord1[copyIndex];
        }
        coord1 = newCoord1;
    }

    //store the value
    coord1[arrayIndex] = userDouble;
    arrayIndex = arrayIndex + 1;

    //take new input
    input = userInput.nextLine();
}