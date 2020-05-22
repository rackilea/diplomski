// Create a new string object
String obj1 = new String("abc");
// Create another new string object but assign obj1 to it.
String obj2 = obj1; // obj1 and obj2 are now located in the same place in memory.

// Compare the two objects
if (obj1 == obj2) {
    // Will always print TRUE
    System.out.println("TRUE"); 
} else {
    // Will never print FALSE
    System.out.println("FALSE"); 
}