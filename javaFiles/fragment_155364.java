import java.util.*;

public class Array
{
    int[] s1 = {1,2,3};
    int[] s2 = {2,3,4};
    int[] s3 = {5,3,6};
    int[] oS1 = {1,2,3};
    int[] oS2 = {2,3,4};
    int[] oS3 = {5,3,6};

    ArrayList<int[]> list1 = new ArrayList<int[]>();
    ArrayList<int[]> list2 = new ArrayList<int[]>();

    public void compareEditArrays(int[] a, int[] b, int[] c, int[] d)
    {
        HashSet<Integer> map = new HashSet<Integer>();
        for (int i : a)
        {
            map.add(i);
        }

        for (int i : b) 
        {
            if (map.contains(i))
            {
                map.remove(i);
            } 
        }

        for (int i : c) 
        {
            if (map.contains(i))
            {
                map.remove(i);
            } 
        }

        arrayWipe(d);

        int x = 0;
        for(int t:map)
        {
            int tempInt = 0;
            int dd=0;

            for(int i:a)
            {
                if(a[dd]==t)
                {
                    tempInt = dd;
                }
                dd++;
            }

            d[tempInt] = t;
            x++;
        }
    }

    public void runCompareEdit()
    {
        compareEditArrays(oS1,oS2,oS3,s1);
        compareEditArrays(oS2,oS1,oS3,s2);
        compareEditArrays(oS3,oS1,oS2,s3);
    }

    public void arrayWipe(int[] a)
    {
        int x=0;
        for(int t:a)
        {
            a[x] = 0;
            x++;
        }
    }

    public void addDisplayFinalArrays()
    {
        System.out.println("Comparing");
        System.out.println("Old");
        list2.add(oS1);
        list2.add(oS2);
        list2.add(oS3);

        for (int[] strArr : list2) 
        {
            System.out.println(Arrays.toString(strArr));
        }

        System.out.println();
        System.out.println("New");
        list1.add(s1);
        list1.add(s2);
        list1.add(s3);

        for (int[] strArr : list1) 
        {
            System.out.println(Arrays.toString(strArr));
        }
    }


    public static void main(String[] args) 
    {
        Array a = new Array();
        a.runCompareEdit();
        a.addDisplayFinalArrays();
    }
}