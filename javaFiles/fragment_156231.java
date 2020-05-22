public class Tackle {
static int[] ages = {2,3,4,5,6,7,8,9,10,11,12,13,14};   // Since the program uses a recursive function,
static StringBuffer sb = new StringBuffer("");          // the variables are declared as static
static int x=0,occurances=0;
static int sum,pdt=1,count=0;
static String[] instances = new String[100];
static void recurse(int a[], int k, int n) throws Exception
{
    if(k==n)    // This program obtains various combinations using binary technique
    {
        for(int i=0;i<n;i++)
            if(a[i] == 1){
                    System.out.print(ages[i]+" ");   // Displays all the combinations available             
                    sum = sum + ages[i];
                    pdt = pdt * ages[i];  
                    count++;                                        
                    sb.append(String.valueOf(ages[i]+" "));
                    }
                    if(Math.pow(sum, 2) == pdt && count<8){     // Checking the criteria
                        instances[occurances++] = sb.toString();
                    }

                    sb = new StringBuffer("");
                    count = 0;
                    sum = 0;
                    pdt = 1;
                    System.out.println("");
    }
    else for(int i=0;i<=1;i++)
    {       
        a[x++] = i;
        recurse(a,k+1,n);
        x--;
    }
}

public static void main(String[] args) throws Exception {
    int[] a = new int[10000];
    recurse(a,0,ages.length);
    if(occurances>0)
    {
        System.out.println("No of combinations matching: " + occurances);
        for(int i=0;i<occurances;i++)
        System.out.println("The combination of ages is [ " + instances[i] + "]");
    }
    else
        System.out.println("No combination matches the criteria. ");
}
}