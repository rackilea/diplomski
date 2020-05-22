int rowCount = 0;
int rows = rowsNumber;
int cols = colsNumber;
double[][] twoD = new double[rows][cols];

while ( ( line=bufferedReader.readLine() ) != null )
{
    String[] allIds = line.split( tabSplit );
    String[] allFloats = new String[allIds.length-2];

    System.arraycopy(allIds, 2, allFloats, 0, allIds.length-2);

    for (int i = 0; i<cols; i++)
    {                    
       twoD[rowCount][i] = Double.parseDouble(allFloats[i]);
    }

    rowCount++
}