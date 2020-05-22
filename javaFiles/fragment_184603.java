public static void main(String[] args) 
{
    int[] array = {3,1,2,4,3,1,3,1};
    int posOfThree = 0;
    int posOfFirstThree = 0;
    boolean noLeft = true;
    boolean noRight = true;
    boolean firstThreeFound = false;
    //Get position of 3
    for (int x=0; x<array.length; x++) 
    {
        if (array[x] == 3)
        {
            if (firstThreeFound == false)
            {   
                posOfFirstThree = x; //Position of the first occurred 3
                firstThreeFound = true;     
            }       
            posOfThree = x;          //Position of the last occurred 3
        }       
    }   

    //Check if there is 1 on left hand side of first 3
    int left = 0;
    while (posOfFirstThree - left > 0)  
    {
        left ++;
        if (array[posOfFirstThree-left] == 1)
            noLeft = false;
    }   

    //Check if there is 1 on right hand side of last 3
    int right = 0;
    while (posOfThree + right < array.length-1) 
    {
        right ++;
        if (array[posOfThree + right] == 1)
            noRight = false;
    }

    System.out.println("Outcome: " + (noLeft || noRight));
}