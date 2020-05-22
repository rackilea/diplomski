Scanner scanner = new Scanner(System.in);

ArrayList<Double> doubles = new ArrayList<Double>();

String inputLine = scanner.nextLine();
String[] splittedInputLine = inputLine.split("\\s+");

for(String doubleString : splittedInputLine) {
    doubles.add(Double.parseDouble(doubleString));
}