// your code here to read the file in

HashMap<String, String> firstNameMap = new HashMap<String, String>();
HashMap<String, String> lastNameMap = new HashMap<String, String>();
HashMap<String, String> dobMap = new HashMap<String, String>();

String line;
while (line = in.readLine() != null) {
    String[] parts = line.split("=");
    if(parts[0].equals("First Name")) {
        String[] values = lineParts[1].split(",");
        for (int i = 0; i < values.length; ++i) {
            firstNameMap.put(i, values[i]);
        }
    }
    else if(parts[0].equals("Last Name")) {
        // do the same as FN but for lastnamemap
    }
    else if(parts[0].equals("Date of Birth") {
       // do the same as FN but for dobmap
    }
}

// Now you can use the length of the map and a random number to get a value
// first name for instance:
int randomNum = ThreadLocalRandom.current().nextInt(0, firstNameMap.size(0 + 1);
System.out.println("First Name: " + firstNameMap.get(randomNum));

// and you would do the same for the other fields