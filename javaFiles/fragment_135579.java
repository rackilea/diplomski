int[] mapTo1DMatrix(int[][] array)
{
    final int elementsPerRow  = array[0].length; // find out the elements in a row, where all rows are same length. 

    for(int arrayRow =0; arrayRow < array.length; arrayRow++)
       for(int col =0; col < elementsPerRow; col ++)
            myOneD[i+arrayRow] = array[arrayRow,col];     

}