import java.math.BigInteger;
import java.util.Scanner;

public class ParitionArray {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int size=Integer.parseInt(s.nextLine());
        long arr[]=new long[size];
        for(int i=0;i<size;i++){
            arr[i]=s.nextLong();
        }
        long minIndex=0;
        BigInteger minNo=BigInteger.ZERO;
        BigInteger[] prefixedMult = new BigInteger[size];
        prefixedMult[0] = BigInteger.valueOf(arr[0]);
        for(int k =1; k< size; k++){
            prefixedMult[k] = prefixedMult[k-1].multiply(BigInteger.valueOf(arr[k]));
        }

        for(int k=0;k<size;k++){
            BigInteger part1 = prefixedMult[k]; //multiplication of A[1]*A[2]A[3].........*A[k]
            BigInteger part2 = prefixedMult[size-1].divide(part1);    //multiplication of A[k+1]A[k+2]...........*A[size]

            BigInteger diff = part1.subtract(part2).abs();
            if(k==0){
                minNo=diff;
                minIndex=k;
            }
            //System.out.println(diff);
            if(minNo.compareTo(diff)==1){
                minNo=diff;
                minIndex=k;
            }
        }
        System.out.println("MinNo: "+minNo+" Index: "+minIndex);
    }
}