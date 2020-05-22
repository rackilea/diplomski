public ArrayList<MyMatrix> permute(char[] array, int num)   //array is the 2D matrix as a single 1D array that is NxM big
{
    ArrayList<MyMatrix> permutations = new ArrayList<MyMatrix>();
    getPermutation(0, num, 0, array.clone(), permutations);  //clone so we don't break the original
    return permutations;
}

public void getPermutation(int depth, int maxDepth, int index, char[] array, ArrayList<MyMatrix> permutations)
{
    if ((index == array.length) || (depth == maxDepth))
    {
        //have to clone because we generate all permutations from the same array
        MyMatrix permutation = new MyMatrix(array.clone());
        permutations.add(permutation);
        return;
    }

    for (int i = index; i < (array.length - (maxDepth-depth)); i++)
    {
        getPermutation(depth+1, maxDepth, index+1, array, permutations);
        array[index] = 1;
        getPermutation(depth+1, maxDepth, index+1, array, permutations);
        array[index] = 0;   //make it as if nothing happened to the number
    }
}

public class MyMatrix
{
    char[] matrix;
    int numOnes;

    public MyMatrix(char[] array)
    {
        matrix = array;
        numOnes = 0;
        for (int i = 0; i < matrix.length; i++)
        {
            if (matrix[i] = 1)
            {
                numOnes++;
            }
        }
    }
}