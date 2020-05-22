class ArraySort
{

    public static void main(String[] args)
    {

        int[] a = {4, 5, 3};
        int[] b = {7, 5};
        int[] c = {7, 8, 9};
        int[] d = {4, 9, 9};
        int[] e = {5, 1};
        int[] f = {3, 8, 2, 5};

        System.out.println("Before sort: 453 75 789 499 51 3825");
        System.out.println("After sort:");

        int[][] compare = {a, b, c, d, e, f};
        int[] temp;

        for (int i = 0; i < 3; i++)
        { // 3 --> max number amount to compare;
            for (int j = 0; j < compare.length - 1; j++)
            {
                if ((compare[i + 1])[i] > (compare[i])[i])
                { // problem is here
                    temp = compare[i];
                    compare[i] = compare[i + 1];
                    compare[i + 1] = temp;
                }
            }
        }

    }
}