Scanner in = new Scanner(System.in);

int LENGTH = 3;
String[] input = new String[LENGTH];
System.out.format("%n%n\tEnter three floating point numbers%n");
for (int i=0; i<LENGTH; i++)
    input[i] = in.nextLine();

//finds the longest number of digits before the dot
int longestCountBeforeDecimalPoint = 0;

for (int i=0; i<LENGTH; i++) {
    int indexOfDot = input[i].indexOf(".");

    if (longestCountBeforeDecimalPoint < indexOfDot) {
        longestCountBeforeDecimalPoint = indexOfDot;
    }
}

System.out.format("\tHere they are lined up on their decimal point%n");

/*This is used to find decimal location in each string*/
int[] decLoc = new int[LENGTH];
for (int i=0; i<LENGTH; i++)
{
    //as R.J noted below, finding dot place can be done like this
    decLoc[i] = input[i].indexOf('.');
}

/*print 5 spaces before number if the decimal is at place 0, 4 spaces for 1...*/ 
for(int i=0; i<LENGTH; i++)
{
    //add spaces
    for (int j=0; j<longestCountBeforeDecimalPoint - decLoc[i] + 1; j++) {
        System.out.print(" ");
    }

    System.out.println(input[i]);
}