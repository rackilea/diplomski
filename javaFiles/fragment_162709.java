String stuffType = "banana";

try {
    stuff.valueOf(stuffType);
} catch(IllegalArgumentException e) {

    // stuff doesn't contain an enum constant with a name that matches the value of stuffType
    System.exit(0);
}