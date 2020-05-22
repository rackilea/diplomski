public class Problem {

    private static void algorithm(int n, int k, int m) {
        algorithmRecursive(Collections.EMPTY_LIST, n, k, m, 1);
    }

    private static void algorithmRecursive(List<Integer> partial, int n, int k, int m, int min) {
        if ( (k > 0) ) {
            // Optimization
            if ((n <= k * m) && (n >= k*min)){
                for (int i = min; i <= Math.min(m, n); i++) {
                    List<Integer> newPartial = new ArrayList<>(partial);
                    newPartial.add(i);
                    algorithmRecursive(newPartial, n - i, k - 1, m, i);
                }
            }
        } else if (n == 0) {
            // Right solution
            System.out.println(partial);
        }
    }

    public static void main(String[] args) {
        algorithm(7,4,3);
    }
}