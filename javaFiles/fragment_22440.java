public static double getAverage(double[][] array1) 
    {
        double total = 0; //Accumulator 
        int num = 0;

        for(int row = 0; row < array1.length; row++) 
        {
            for(int col =0; col < array1[row].length; col++) {
                 total += array1 [row][col];
                 num += 1;
            }
        }

        return total / num;
    }