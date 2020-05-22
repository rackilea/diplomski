JButton button = (JButton) evt.getSource();
String text = button.getText();
// If you wanted to use the name of the button instead...
String name = button.getName();

// You would use this if you need part of the text...
char charPressed = Character.toLowerCase(text.charAt(0)); 
// You could to this to convert the character to a String for easier
// comparison...
String strCharPressed = Character.toString(text.charAt(0)).toLowerCase(); 

// A sample
String word = "This is a test";

// Finds the first occurrence of the character in the String...
// Comparison is case sensitive...
// If indexOf > -1 then the word contains the character
int indexOf = word.toLowerCase().indexOf(charPressed);
// Or, you just check to see if it is contained in the word...
boolean contains = word.toLowerCase().contains(Character.toString(charPressed));

System.out.println("indexOf = " + indexOf);
System.out.println("contains = " + contains);