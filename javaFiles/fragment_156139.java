public static void main(String[] args) {
    System.out.println("Final Output in Main "+prod(1, 4));
}

public static int prod(int m, int n) {
    if (m == n) {
        System.out.println("Return Result: "+n);
            return n;
    } else {
        System.out.println("Print : "+n);
            int recurse = prod(m, n - 1);
        System.out.println("Print Recurse: "+recurse);
            int result = n * recurse;
        System.out.println("Return Result: "+result);
            return result;
    }
}