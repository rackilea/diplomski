double sum=0, ave;

int x = khel.nextInt();
int y = khel.nextInt(); // input for array sizes
int val = x * y;

double rowSum; // something to contain data

double[][] myArray = new double[x][y];

for(int i=0; i < myArray.length; i++)
{
    for(int j=0; j < myArray[i].length; j++)
    {
        myArray[i][j] = khel.nextDouble(); // input for array content
    }
}

for(int i=0; i < myArray.length; i++)
{
    rowSum = 0; // reset value each row

    for(int j=0; j < myArray[i].length; j++)
    {

        System.out.print(myArray[i][j] + "\t");
        sum +=  myArray[i][j];

        rowSum += myArray[i][j]; // add value from array
    }
    System.out.println(rowSum / (double)myArray[i].length); // print average from each row

    System.out.println("");
}
System.out.println("The sum of all numbers is " + sum + ".");

// this is the average of the whole table
ave = sum / val; 
System.out.println("The average of all numbers is " + ave + ".");