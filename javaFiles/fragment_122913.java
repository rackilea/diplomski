public class ArraySorter
    {
    public static void main(String[] args)
    {
        int[] siyahi = RandomArrayCreator.create();
        int[] siralanmish = new int[siyahi.length];

        for (int i=0;i<siyahi.length;i++)
        {
            for (int j=0;j<siyahi.length;j++)
            {
                for (int k=j+1;k<siyahi.length;k++)
                {
                    if (siyahi[k]<siyahi[j]) 
                    {
                      int temp = siyahi[j];
                      siyahi[j] = siyahi[k];
                      siyahi[k] = temp;
                    }
                }
                siralanmish[j]=siyahi[j];
            }
            System.out.println(siralanmish[i]);
        }
    }