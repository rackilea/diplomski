private static void swap(int[] v, int i, int j) {
        int temp = v[i]; 
            v[i] = v[j];
            v[j] = temp;
    }

    public void permute(int[] v, int n) {
        if (n == 1) {
            System.out.println(Arrays.toString(v));
        } else {
            for (int i = 0; i < n; i++) {
                permute(v, n-1);
                if (n % 2 == 1) {
                    swap(v, 0, n-1);
                } else {
                    swap(v, i, n-1);
                }
            }
        }
    }