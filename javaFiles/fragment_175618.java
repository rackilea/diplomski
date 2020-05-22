List<?> matrices = new ArrayList<?>();
while ((smaLine = reader.readLine()) != null)
{
    float[][] mat = new float[MATRIX_ROWS][MATRIX_COLUMNS];
    String[] values = smaLine.split(", ");
    for(int i = 0; i < values.length; i++)
    {
        float[] testC = float(split(values[i], " "));
        for (int j = 0; j < testC.length; j++)
        {
            mat[j][i] = testC[j];
        }
    }
    matrices.add(mat);
    x = x+1;
}