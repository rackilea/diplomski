public class Test {
    public static int reverse (int num) {
        int rnum = 0;
        while (num > 0) {
            rnum = (rnum * 10) + (num % 10);
            num = num / 10;
        }
        return rnum;
    }

    public static boolean isPalindrome (int num) {
        return (num == reverse (num));
    }

    public static void main(String args[])
    {
        System.out.println(isPalindrome (767));       
        System.out.println(isPalindrome (12321));       
        System.out.println(isPalindrome (4));       
        System.out.println(isPalindrome (314159));       
    }
}