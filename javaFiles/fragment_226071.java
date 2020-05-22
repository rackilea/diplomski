public class ArrayDuplicate {
    public void run1()
    {
        int[] a = {10, 20, 30, 40, 40, 40, 50, 40, 60, 70, 80 ,10};
        int size=a.length;
        System.out.println("Array size before duplicate deletion "+size);
        for(int i =0;i<(size-1);i++)
        {
            for(int j=i+1;j<=(size-1);j++)
            {
                if(a[i]==a[j] &&i!=j)
                {      
                    int temp = j;
                    while(temp<(size-1))
                    {
                        a[temp]=a[temp+1];
                        temp++;
                    }
                    size--;
                    j=i;  
                }

            }
        }
        System.out.print("The array after deleting the duplicates is ");
        for(int k=0;k<=(size-1);k++)
        {
            System.out.print(a[k]);  //40 is being printed twice
            if(k<(size-1))
            {
                System.out.print(",");
            }
            else
                System.out.print(".");
        }
    }
    public static void main(String[] args)
    {
        ArrayDuplicate ob = new ArrayDuplicate();
        ob.run1();

    }
}