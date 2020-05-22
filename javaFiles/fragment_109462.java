String line; // Put the line in here however you're reading from the file.
String[] sections = line.split(";");
// Assuming you know there are always two sections, names and addresses:
String[] names = sections[0].split(",");
String[] addresses = sections[1].split(",");

// Convert arrays into ArrayLists if you actually need to
List<String> namesList = new ArrayList<>( Arrays.asList( names ) );
List<String> addressList = new ArrayList<>( Arrays.asList( addresses ) );