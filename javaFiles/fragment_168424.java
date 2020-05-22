public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter first number: ");
    long n1 = sc.nextLong();
    System.out.println("Enter second number: ");
    long n2 = sc.nextLong();
    long sum = n1+n2;

    StringBuilder reverseSum = new StringBuilder(Long.toString(sum));
    System.out.println("The reversed sum is " + reverseSum.reverse());
}