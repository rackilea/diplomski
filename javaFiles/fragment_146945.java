// Build the string
String content = ("Surname " + (surname) + LINE_SEPARATOR + "First name: " + (firstname);

// Read all contents into a String
byte[] bytes = Files.readAllBytes(Paths.get("C://Users/Prakt1/Desktop/projektverwaltung.txt"));
String s = new String(bytes);

// Check if the name is contained
if(s.indexOf(content) != -1){
     System.out.println("Name already present!");
} else {
     ... // Do your usual insertion
}