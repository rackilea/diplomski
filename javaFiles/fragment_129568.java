private static String[][] resultCard = new String[][] {
    { " ", "A", "B", "C"},
    { "Maths", "78", "98","55"},
    { "Physics", "55", "65", "88"},
    { "Java", "73", "66", "69"},
};

public static void A() {
    // "Not sure how I can include the array (myArray) here"
    // You can access it and work with it simply by using its name:
    System.out.println(resultCard[3][0]); // Prints "Java"
    resultCard[3][0] = "Easy";
    System.out.println(resultCard[3][0]); // Prints "Easy"
}