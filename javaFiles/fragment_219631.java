public static void main(String[] args) {
    factorial(10);
}
//Calculates the factorial of integer n
public static int factorial(int n) {
    if (n == 0)
        return 1;
    else {
        int newVal = n*factorial(n-1);
        System.out.println(newVal);
        return newVal;
    }
}