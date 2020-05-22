public class Test {

    public static long getNumber(long input) {
       while(input > 101) {
           input = input /10;
       }
       return input;
    }


    public static void main(String[] args){

       System.out.println(getNumber(101111));
       System.out.println(getNumber(89123));
    }
}