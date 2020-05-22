BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

String inputString = bufferedReader.readLine();

String doubleRegex = "[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?";
String integerRegex = "[-+]?[0-9]+";

if (inputString.matches(integerRegex)) {
    System.out.println("integer");
} else
if (inputString.matches(doubleRegex)) {
    System.out.println("double");
} else {
    // Error inputted string can't be parsed
}