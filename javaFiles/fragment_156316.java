class Main {
    public static void main(String[] args) {
        String x = "ababbabbabbababbabb";

        int[] prefix = computePrefix(x);

        System.out.println("Prefix series for " + x);
        for (int p : prefix) {
            System.out.print(p + " ");
        }
        System.out.println();
    }

    public static int[] computePrefix(String input) {
        int[] pi = new int[input.length()];

        int k = 0;
        for(int q = 2; q < input.length(); q++) {            
            while (k > 0 && input.charAt(k) != input.charAt(q)) {
                k = pi[k];
            }
            if (input.charAt(k) == input.charAt(q)) {
                k = k + 1;
            }
            pi[q] = k;
        }
        return pi;
    }
}