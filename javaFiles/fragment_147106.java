public class aermel_Perfect
{
public static void main ( String args [] )
{
    int gN;
    int gP = getPerfect();
    int [] array = new int[100];
    array=testPerfect(gP,array);
    //int printFactors;
    System.out.println(Arrays.toString(array));
}


public static int getNum() //Get amount of numbers to check
{
Scanner input = new Scanner ( System.in );
System.out.print( "How many numbers would you like to test? " );
int count = input.nextInt();
int perfect = 1;
boolean vN = validateNum(count, perfect);
while(!vN)
{
    System.out.print (" How many numbers would you like to test? ");
    count = input.nextInt();
    vN = validateNum(count, perfect);
}
return count;
}   

public static boolean validateNum( int count, int perfect  ) //Check if number is valid
{
if (( count <= 0) || ( perfect <= 0))

{ 
    System.out.print( "Non-positive numbers are not allowed.\n");
}



else 
{
    return true;
}
return false;


}
public static int getPerfect() //Gets the numbers to test
{
Scanner input = new Scanner ( System.in );
int perfect = -1;
int count = getNum();
System.out.print("Please enter a perfect number: " );
perfect = input.nextInt();  
boolean vN = validateNum(perfect, count);
while (!vN) 
{
    System.out.print("Please enter a perfect number: ");
    perfect = input.nextInt();
    vN=validateNum(perfect, count);
}
return perfect;
}


public static int[] testPerfect( int perfect, int[] array )

{
//testPerfect(perfect, array);
int limit = (int) Math.ceil(Math.sqrt(perfect));
int index = 0;
for ( int i = 1; i <=limit; i++)
{
    array[index++] = i;
    perfect /= i;
}
array[index] = perfect;

return array;


}






}