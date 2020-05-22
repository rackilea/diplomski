Scanner reader = new Scanner(System.in);
List<Integer> numbers = new ArrayList<>();

int numbersEntered = 0; // Stores how many numbers the user has entered so far
while (numbersEntered < 5) { // Keep asking if they have not entered 5 numbers yet
    System.out.println("Enter a string of numbers");
    String[] input = reader.nextLine().split(" "); // Split the input by spaces into an array
    numbersEntered += input.length; // Add the number of numbers they entered to the variable
    for (int i = 0; i < input.length; i++) {
        if (numbers.size() < 5) { // Only add the numbers if the list is not full
             numbers.add(Integer.parseInt(input[i])); // Add each number they entered to the numbers list
        }
    }
}