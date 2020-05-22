import java.util.*;

public class Revision {

static int NO_LIMIT = 4;
static int[] num = new int[NO_LIMIT];
static int i ;
static int sum;

public static void main(String arg[]) {

    Scanner sc=new Scanner(System.in);
    int count = 0;
    while(count < NO_LIMIT){
        System.out.print("Enter the number" + (count+1) +":");
        num[count] = sc.nextInt();
        count ++;
    }
    for(i=0; i<num.length; i++) {
            sum=sum + num[i];
        }

    System.out.print("Sum=" + sum);
}

}