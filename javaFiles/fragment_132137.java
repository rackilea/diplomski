public static void main(String[] args) 
{
       Scanner input = new Scanner (System.in);
       try
       {
       System.out.println("Number of times to loop:");

       int numEntries = input.nextInt();
       int[][] valueArrays = new int[numEntries][];

        for (int i=0; i<numEntries; i++)
        {
            System.out.println("Size of array #"+i+": ");
            int arrayLen = input.nextInt();
            int[] inputArray = new int[arrayLen];
            for (int j = 0; j < arrayLen; j++)
            {
              System.out.println("Enter value at index "+j+": ");
              inputArray[j] = input.nextInt();
            }

            Arrays.sort(inputArray);
            valueArrays[i] = inputArray;
        }

        for (int l=0; l < valueArrays.length; l++)
        {
            int[] values = valueArrays[l];
            for (int m=0; m < values.length; m++)
            {
                System.out.println("Value of array #"+l+" saved at index "+m +": " + values[m]);
            }

            if ((values.length % 2) == 0)
            {
                int start = values.length/2;
                int end = start + 1;
                System.out.println("Middle values in array #"+l+" saved at indices " + start + " and " + end);                                          
            }
            else
            {
                int start = values.length/2;
                System.out.println("Middle value in array #"+l+" saved at index " + start);                                         
            }

        }

    }
    finally
    {
        input.close();
    }

}