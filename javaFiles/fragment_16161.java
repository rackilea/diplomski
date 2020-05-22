class Ragged
    {
     public static void main(String args[])
     {
       //declaration of a ragged array
       int arr[][] = new int[3][];
       //declaration of cols per row
       arr[0] = new int[4];
       arr[1] = new int[2];
       arr[2] = new int[3];

       int i, j;

       for(i =0; i< arr.length; i++)
       {
        for(j =0 ; j< arr[i].length; j++)
        {
           arr[i][j] = i + j+ 10;
        }
       }

       for(i =0; i< arr.length; i++)
       {
        System.out.println();//skip a line
        for(j =0 ; j< arr[i].length; j++)
        {
           System.out.print(arr[i][j]  + "  ");
        }
       }




//-------------more----------------
   int temp[];//int array reference
   //swap row2 and row3 of arr
   temp = arr[1];
   arr[1] = arr[2];
   arr[2] = temp;


   System.out.println();//skip a line
   for(i =0; i< arr.length; i++)
   {
    System.out.println();//skip a line
    for(j =0 ; j< arr[i].length; j++)
    {
       System.out.print(arr[i][j]  + "  ");
    }
   }

 }//main
}//class