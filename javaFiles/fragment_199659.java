// This program will output the following type of pyramid
//   db
//  d00b
public static void main(String[] args){
    //a scanner is a tool for reading input from a stream
    //in this case, you are reading from the user input window (console)
    //Scanner keyboard = new Scanner(System.in);

    //asks users how many rows of a pyramid they want
    System.out.print("How many rows?: ");
    //int amountOfRows = keyboard.nextInt();

    for(int i = 0; i < 5; i++)
    {           
        printPyramid(i);
        System.out.println("\n\n"); //this line essentially prints a newline x3
    }
}

public static void printPyramid(int amountOfRows)
{
   int maxIndentation = amountOfRows + 2;


    for(int row = 0; row < amountOfRows; row++){
        int antallx = 2*row;

        for(int column = 0; column < maxIndentation - antallx / 2; column++){
            System.out.print("|");
            //I changed " " to "|" so you can see what this for loop is printing
        }

        System.out.print("d");
        for(int kolonne = 0; kolonne < antallx; kolonne++){
            System.out.print("0");
        }
        System.out.println("b");
    }
}