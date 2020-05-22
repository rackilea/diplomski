private static int[] sortBuble(int[] a) {
        boolean swapped = true;
        int n = a.length;
        for (int i = 0; i < n && swapped; i++) {
            swapped = false;
            int newn = 0;
            System.out.println("number of iteration" + i);

            for (int j = 1; j < a.length; j++) {

                if (a[j-1] > a[j]) {
                    int temp = a[j-1];
                    a[j-1] = a[j];
                    a[j] = temp;
                    swapped = true;
                    newn = j;
                }
            }
            n = newn;
        }

        return a;
    }