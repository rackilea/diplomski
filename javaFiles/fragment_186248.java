public class MyClass {
    public static void main(String args[]) {


        System.out.println("total zeroes = " + returnZeroesCount(40300));
    }
    public static int returnZeroesCount(int input){
        if(input == 0)
            return 0;
        int n = input % 10;
        return n == 0 ? 1 + returnZeroesCount(input / 10) : returnZeroesCount(input / 10);
    }
}