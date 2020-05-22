BufferedReader r = new BufferedReader(new InputStreamReader(System.in));  // Optionally add a charset as 2nd parameter.
String street;
while (true) {
    System.out.println("Please enter a valid street name>> " );
    try {
        String line = r.readLine();
        // Accept a line with alphabetic characters delimited with space.
        if (line.matches("[A-Za-z ]+$")) {
            street = line;
            break;
        }
    } catch (IOException e) {
        // Handle broken input stream here.
        street = "";
        e.printStackTrace();
        break;
    }
}
System.out.println(street);