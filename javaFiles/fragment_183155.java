// Create two Strings with the same text "abc"
String obj1 = new String("abc");
String obj2 = new String("abc");

// Compare the two String values using equals()
if (obj1.equals(obj2)) {
    // Will always print TRUE because the two string values
    // are equal/the same.
    System.out.println("TRUE"); 
} else {
    // Will never print FALSE
    System.out.println("FALSE"); 
}