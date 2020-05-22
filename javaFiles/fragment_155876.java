//method to check whether the sum of the columns are 1
public static boolean columnSum (double[][] array)
{
    //declarations 
    double sum = 0; 
    boolean answer = true;

    //processing
    for (int i = 0; i < array.length; i++)
    {
        sum = 0; //-----------------added-----------------
        for (int x = 0; x < array.length; x++)
        {
            sum += array[i][x]; 
        }
        if (sum != 1)
        {
            answer = false; 
        }
    }
    return answer;  
}