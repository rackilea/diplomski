static int[] selectionSort(int[] input) {
    if (input.length == 0) {
        return null;
    }
    else {
        int pos = -1;
        for (int i=0;i<input.length-1;i++) {
            pos = i;
            for (int j=i+1;j<input.length;j++) {
                if (input[j] < input[pos]) {
                    pos = j;
                }
            }
            int temp = input[pos];
            input[pos] = input[i];
            input[i] = temp;
        }       
    }
    return input;
}