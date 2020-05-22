Scanner myScanner = new Scanner(System.in);
String input = myScanner.nextLine();

// has all the numbers but isn't dynamic
String[] numbers = input.split(",");

// now you can dynamically add or remove items without big effort
ArrayList<String> demNumbers = new ArrayList<>(Arrays.asList(numbers));