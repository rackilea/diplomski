// Create two Strings with the same text "abc"
String obj1 = new String("abc");
String obj2 = new String("abc");

// Compare the two Strings
if (obj1 == obj2) {
    // Will never reach here and print TRUE
    System.out.println("TRUE"); 
} else {
    // Will always print FALSE
    System.out.println("FALSE"); 
}