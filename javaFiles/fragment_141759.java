int num1 = 0;
int num2 = 0;
int num3 = 0;
int num4 = 0;
int num5 = 0;

public class Tester {
    int num1 = 0;
    int num2 = 0;
    int num3 = 0;
    int num4 = 0;
    int num5 = 0;

    public static void main(String args[]) {
        new Tester();
    }

    public Tester(){
        checkThisNumber(5);
        checkThisNumber(6);
        checkThisNumber(3);
        checkThisNumber(4);
        checkThisNumber(2);
        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num3);
        System.out.println(num4);
        System.out.println(num5);
    }

    private void checkThisNumber(int n) {
        if (n < num2) {
            num1 = n;
        } else if (n < num3) {
            num1 = num2;
            num2 = n;
        } else if (n < num4) {
            num1 = num2;
            num2 = num3;
            num3 = n;
        } else if (n < num5) {
            num1 = num2;
            num2 = num3;
            num3 = num4;
            num4 = n;
        } else {
            num1 = num2;
            num2 = num3;
            num3 = num4;
            num4 = num5;
            num5 = n;            
        }                
    }   
}