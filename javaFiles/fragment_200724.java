static int maxElement(int[] arr) {
        Arrays.sort(arr);
        for (int k = arr.length-1; k >= 0; k--) {
            int max = arr[k];
            int result = 0;
            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    result = arr[i] * arr[j];
                    if (result == max) {
                        return max;
                    }
                }
            }   
        }
        return -1;
    }