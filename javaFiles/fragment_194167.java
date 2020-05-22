public static double[][] addMatrices(double doubMatrix1[][], 
                                     double doubMatrix2[][]){

for(int i = 0; i< doubMatrix1.length;i++)
    for(int j = 0; j< doubMatrix1[i].length;j++ )
    {
        if(doubMatrix1[i][j] == doubMatrix2[i][j])
        {
            double[][] tempArray = new double[i][j];

        }
        else
        {
            return tempArray[0][0]; 
        }
    }

return tempArray;
}