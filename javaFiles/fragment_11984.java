import java.util.Scanner;

public class Averages{
    public static void main(String []args){
        double swap,sum=0;
        int d, c, n;
        Scanner in = new Scanner(System.in);
        System.out.println("Input number of integers to sort");
        n = in.nextInt();
        double array[] = new double[n];
        System.out.println("Enter " + n + " integers");
        for (c = 0; c < n; c++){
            array[c] = in.nextDouble();
            sum=sum+array[c];
        }

        for (c = 0; c < ( n - 1 ); c++) {
            for (d = 0; d < n - c - 1; d++) {
                if (array[d] > array[d+1]) /* For descending order use < */
                {
                    swap = array[d];
                    array[d] = array[d+1];
                    array[d+1] = swap;
                }
            }
        }
        System.out.println("Sorted array:");
        for (c = 0; c < ( n - 1 ); c++) {
            System.out.println(array[c]);
        }


        System.out.println("Sum="+sum);
        System.out.println("Max="+array[n-1]);
        System.out.println("Min="+array[0]);
        System.out.println("Mean="+sum/n);

        double median = 0;
        double mid=0;
        if(n%2 == 0)
        {
            int temp=(n/2)-1;
            for(int i=0;i<n;i++)
            {
                if(temp==i || (temp+1)==i)
                {
                    mid=mid+array[i];
                }
            }
            mid=mid/2;
            System.out.println("Median value is: "+mid);
        }
        else
        {
            int temp=(n/2);
            for(int i=0;i<n;i++)
            {
                if(temp==i)
                {
                    mid=array[i];
                    System.out.println("Median value: "+mid);
                }
            }
        }
//Mode calculation
        int i,j,z, maxCount;
        double tmp, modeValue;
        int[] tally=new int[n];
        for(i=0;i<n;i++)
        {
            for(j=0;j<n-i;j++)
            {
                if(j+1!=n)
                {
                    if(array[j]>array[j+1])
                    {
                        tmp=array[j];
                        array[j]=array[j+1];
                        array[j+1]=tmp;
                    }
                }
            }
        }
        for (i = 0; i < n; i++)
        {
            for(z=i+1;z<n;z++)
            {
                if(array[i]==array[z])
                {
                    tally[i]++;
                }
            }
        }
        maxCount = 0;
        modeValue = 0;
        for (i = 0; i <n; i++)
        {
            if (tally[i] > maxCount)
            {
                maxCount = tally[i];
                modeValue = array[i];
            }
        }
        System.out.println("Mode value is :"+modeValue);
    }
}