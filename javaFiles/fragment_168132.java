List<Integer> go(int[][] mat) 
{
    int capacity = mat.length * mat[0].length; // Not needed.
    List<Integer> list = new ArrayList<>(capacity);
    for (int i = 0; i < mat.length; i++) 
    {
        for (int j = 0; j < mat[i].length; j++) 
        {
            list.add(mat[i][j]);
        }
    }
    return list;
}