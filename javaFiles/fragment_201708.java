String input = "40.2%2522%26url%3Dhttp%253A%252F%252Fr1";
String output = input;

do {
    input = output;
    output = URLDecoder.decode(input, "UTF-8");

} while (!input.equals(output));