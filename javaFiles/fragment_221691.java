class Ideone
{
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        int[] myArray = {4, 6 , 9};
        for(int x : myArray)
        {
            System.out.println(x);
        }
        //or....

        for(int x =0; x<3; x++)
        {
            System.out.println(myArray[x]);
        }
    }
}