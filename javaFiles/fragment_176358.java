Scanner getLine = new Scanner(System.in);
String userSays;

Cat[] catList = new Cat[5]; // create array of 5 cats

int catCount = 0;

// loop to get all the user input for the cats
for (Cat cat : catList) // for each cat in cat array (5 cats)
{
    System.out.println("Wow! A brand new cat! What's its name?");

    userSays = getLine.next(); // get the cat name

    catList[catCount] = new Cat(userSays); // set this cat in the cat array to be
                                           // the user input

    catCount++; // + the catCount, so the next cat in the cat array is focused on
}

// loop to display all of the cats back to the console
for (Cat cat : catList) // for each cat in the cat array
{
    // display the cat's name in this iteration of the cat array
    System.out.println ("The new cat's name is " + cat.getcatName() + "!");
}