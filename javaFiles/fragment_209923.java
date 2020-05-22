Scanner scnr = new Scanner(System.in);

int arrowBaseHeight = 0;
int arrowBaseWidth  = 0;
int arrowHeadWidth = 0;
int i = 0;

System.out.println("Enter arrow base height: ");
arrowBaseHeight = scnr.nextInt();

System.out.println("Enter arrow base width: ");
arrowBaseWidth = scnr.nextInt();

System.out.println("Enter arrow head width: ");
arrowHeadWidth = scnr.nextInt();

//Your code above | Below is the modified code

String ast = ""; //String ast will contain how many asterisk we want for the base width;

for (int x = 1; x <= arrowBaseWidth; x++) //Loop forms the base width of the arrow
{
    ast += "*"; //This adds as many asterisks as we need to make the base width. SO if they enter 4, we get 4 *;
}


for (i = 1; i < arrowBaseHeight; ++i) 
{   
    System.out.println(ast); //Prints out the base width, which is now a String object
}

int tempHeadWidth = arrowHeadWidth; //Added this tempHeadWidth variable since we will be modifying it directly and 
                                    //we don't want to modify the original data and variable (it will cause problems if we do.

for (int y = 1; y <= arrowHeadWidth; y++) 
{
    for(int z = tempHeadWidth; z > 0; z--) //This loop prints the amount of asterisks we need per line in the arrowHead
    {
        System.out.print("*");
    } 
    // Once the loop above is finished, the rest of the code will execute in the main for-loop and then scheck if it will run again.
    tempHeadWidth -= 1; //So we are lowering the tempHeadWidth by one so the next time it enters 
                        //the nested (2nd) for loop it will be one asterisk smaller

    System.out.println(); //This makes a new line to keep adding more stars for the next row 
}