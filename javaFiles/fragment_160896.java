int[][] a = { { 4, 16, 5 }, { 1, 12, 1 }, { 8, 9, 13 }, { 3, 4, 7 } };

for (int i = 0; i < a.length; i++) {
    int[] inner = a[i];
    for (int k = 0; k < inner.length; k++) {
        int current = inner[k]; // current value being compared

        // copy the remaining items in the array to a new array for iterating 
        int[] subInner = Arrays.copyOfRange(inner, k + 1, inner.length);

        for (int n = 0; n < subInner.length; n++) {
            int comparedTo = subInner[n]; // current value that "current" is comparing itself to
            System.out.println("array " + (i + 1) + " compare " + current + " to " + comparedTo);

            if (current == 4 && comparedTo == 16) {
                System.out.println("4->16");
            } else if (current == 12 && comparedTo == 1) {
                System.out.println("12->1");
            } else if (current == 9 && comparedTo == 13) {
                System.out.println("9->13");
            } else if (current == 3 && comparedTo == 7) {
                System.out.println("3->7");
            }
        }
    }
}