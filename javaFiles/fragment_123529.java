public class multiples_of_13 {
    public static void main(String[] args) {
        int[] thirteens = new int[400];
        int numFound = 0;
        // candidate: the number that might be a multiple
        // of 13
        int candidate = 1;

        System.out.println("the first 400 multiples of 13:" );

        while (numFound < 400) {
            if (candidate % 13 == 0) {
                thirteens[numFound] = candidate;
                numFound++;
            }
            candidate++;
        }
        System.out.println("First 400 multiples of 13:");
        for (int i = 0; i < 400; i++) {
            System.out.print(thirteens[i] + " ");
        }
    }
}