import java.util.*;
public class BitSetAddition
{
static String nums[] = {"0000","0001","0010","0011","0100","0101","0110","0111","1000","1001","1010","1011","1100","1101","1110","1111"};
public static void main(String args[])
{
    for(int q=0;q<nums.length;q++)
    {
        System.out.print(q+1+" -> ");
        BitSet b1 = new BitSet();
        String s = nums[q];
        b1.set(0, s.charAt(0)=='1'?true:false);
        b1.set(1, s.charAt(1)=='1'?true:false);
        b1.set(2, s.charAt(2)=='1'?true:false);
        b1.set(3, s.charAt(3)=='1'?true:false);

        for(int i=0;i<4;i++)
            System.out.print(b1.get(i)?"1":"0");
            System.out.print(" + ");

        BitSet b2 = new BitSet();
        String a = "0001";
        b2.set(0, a.charAt(0)=='1'?true:false);
        b2.set(1, a.charAt(1)=='1'?true:false);
        b2.set(2, a.charAt(2)=='1'?true:false);
        b2.set(3, a.charAt(3)=='1'?true:false);

        for(int i=0;i<4;i++)
            System.out.print(b2.get(i)?"1":"0");
            System.out.print(" = ");

        BitSet sum = new BitSet();
        BitSet carry = new BitSet();
        BitSet toAdd = new BitSet();
        BitSet tempSum = new BitSet();
        BitSet tempCarry = new BitSet();

        sum = b1;
        toAdd = b2;
        do
        {
            copy(4, tempSum, sum);
            copy(4, tempCarry, toAdd);
            tempSum.xor(toAdd);
            tempCarry.and(sum);
            copy(4, sum, tempSum);
            copy(4, carry, leftShift(4, tempCarry));
            copy(4, toAdd, carry);
            //sum.set(i, b1.get(i)^b2.get(i)^(b1.get(i+1)&b2.get(i+1)));
        }while(!carry.equals(new BitSet()));
            //if(i+2<=3)
                //sum.set(i, b1.get(i)^b2.get(i)^(b1.get(i+1)&b2.get(i+1)&(b1.get(i+2)&(b2.get(i+2)))));
            //else if(i+1<=3)
                //sum.set(i, b1.get(i)^b2.get(i)^(b1.get(i+1)&b2.get(i+1)));
            //else
                //sum.set(i, b1.get(i)^b2.get(i));
        for(int i=0;i<4;i++)
            System.out.print(sum.get(i)?"1":"0");

        System.out.println();
    }
}
static void copy(int n,BitSet b, BitSet toCopy)
{
    for(int i=0;i<n;i++)
        b.set(i, toCopy.get(i));
}
static BitSet leftShift(int n, BitSet b)
{
    for(int i=0;i<n;i++)
        b.set(i, b.get(i+1));
        b.set(n-1, false);
        return b;
}
}