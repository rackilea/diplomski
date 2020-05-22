System.out.println("Enter numbers  <enter -1 to stop>");

ExampleClass ex = new ExampleClass();
boolean inputData = true;

while (inputData) { // loop until it's false to keep gaining numbers
    Scanner input = new Scanner(System.in); // to get input
    inputData = ex.inputData(input.nextInt()); // equals the return of inputData
}