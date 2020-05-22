Scanner input = new Scanner(System.in);
String userInput;
System.out.print("Enter a line of words: ");
userInput = input.nextLine().replace(" ", "").toLowerCase();
String[] userInputSplit = userInput.split(""); // Splits array
Arrays.sort(userInputSplit); // Sorts array
System.out.println(Arrays.toString(userInputSplit)); // Prints sorted array
// Checks for frequency of each letter using maps
Map<String, Integer> countMap = Arrays.stream(userInputSplit)
        .collect(Collectors.toMap(Function.identity(), v -> 1, Integer::sum));
// Prints map
System.out.println("Frequency of words: " + countMap.toString());