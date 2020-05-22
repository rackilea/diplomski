//when n and r are known statically

class Permutation
{
    public static void main(String[] args)
    {
        char[] values = {'a', 'b', 'c', 'd'};
        int n = values.length;
        int r = 2; 

        int i = 0, j = 0;
        for(i=0; i<n; i++)
        {
            for(j=0; j<n; j++)
            {
                System.out.println(values[j] + " " + values[i]);
            }
        }
    }
}


//when n and r are known only dynamically

class Permutation
{
    public static void main(String[] args)
    {
        char[] values = {'a', 'b', 'c', 'd'};
        int n = values.length;
        int r = 2; 
        int i[] = new int[r];
        int rc = 0;
        for(int j=0; j<Math.pow(n,r); j++)
        {

            rc=0;
            while(rc<r)
            {
                System.out.print(values[i[rc]] + " ");
                rc++;
            }
            System.out.println();
            rc = 0;
            while(rc<r)
            {
                if(i[rc]<n-1)
                {
                    i[rc]++;
                    break;
                }
                else
                {
                    i[rc]=0;
                }
                rc++;
            }
        }
    }
}