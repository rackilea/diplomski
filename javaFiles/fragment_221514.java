// Declare and allocate the array
GameEntry[] scoreArray = new GameEntry[4];

// Set elements at indices 0-3
scoreArray[0] = new GameEntry(10);
scoreArray[1] = new GameEntry(100);
scoreArray[2] = new GameEntry(1000);
scoreArray[3] = new GameEntry(10000);

// Iterate the array
for (int i = 0; i < scoreArray.length; i++) {
    // Access the element at index i
    GameEntry currentObject = scoreArray[i];

    // Print some info about the object
    System.out.println("Current object is: " + currentObject);
    System.out.println("It has a score of: " + currentObject.scores);
}