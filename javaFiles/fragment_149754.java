private static int[][] parseTwoDimension(String strInput)
{
    String[] rows = strInput.split("!");    
    int[][] arr = new int[rows.length()][];

    for(int i = 0; i < rows.length; i++)
    {
        String[] elements = rows[i].split("");
        int[] intElements = new int[elements.length];

        for(int j = 0; j < elements.length; j++)
        {
            intElements[j] = Integer.parseInt(elements[j]);
        }
        arr[i] = intElements;
    }
}