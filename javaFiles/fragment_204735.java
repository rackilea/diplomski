// Example input
String input  = "1 2 3 4 5";

// Split elements by space
// So you receive array: {"1", "2", "3", "4", "5"}
String[] numbers = input.split(" ");

for (int position = 0; position < numbers.length; position++) {
    // Get element from "position"
    System.out.println(numbers[position]);
}