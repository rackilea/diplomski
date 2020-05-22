// Example input
String input = "1 2 3 4 5";

// Split elements by space
// So you receive array: {"1", "2", "3", "4", "5"}
String[] strings = input.split(" ");

// Create new array for "ints" (with same size!)
int[] number = new int[strings.length];

// Convert all of the "Strings" to "ints"
for (int position = 0; position < strings.length; position++) {
    number[position] = Integer.parseInt(strings[position]);
}