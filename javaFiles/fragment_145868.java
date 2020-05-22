public class Sum {
    public static void main(String[]args){
        int sumOfPos = 0;
        int sumOfNeg = 0;
//should give 1 , 5 , 9
    for(int pos = 1 ; pos<= 9; pos+=4){
        int Old = pos*pos;
        sumOfPos = pos + Old;
    }
//should give -3 and -7
    for(int neg = -3 ; neg>= -7; neg-=4){
        int Old = neg*neg;
        sumOfNeg = neg + Old;
    }
// should give the sum of the sqaure of these numbers
int sum = sumOfPos + sumOfNeg;
System.out.println(sum);