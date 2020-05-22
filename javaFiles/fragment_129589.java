class A {
    public static void main(String[] args) {
        int n = 13;
        found: {
            for (int x : new int[]{2,3,4,5,6,7,8,9,10,11,12})
                if (n % x == 0) {
                    System.out.println("" + n + " equals " + x + "*" + (n/x));
                    break found;
                }
            System.out.println("" + n + " is a prime number");
        }
    }
}