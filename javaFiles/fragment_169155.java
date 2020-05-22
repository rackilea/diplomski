class C4h8
{
    public static void main(String[] args)
    {
        int i, j;

        i = 1;
        while(i <= 10)
        {
            j = 1;
            while (j <= i) // limit the variable j by i 
            {

                System.out.print(j+" ");
                j++;

            }

            System.out.println();
            i++;

        }
    }
}