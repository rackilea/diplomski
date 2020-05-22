int[] generateNumbers(int m, int n) {
    if(m < 0 || n <= 0) throw new IllegalArgumentException();
    if (n == 1) return new int[]{m};
    int separatorNum = n - 1;
    int permutationLength = m + n - 1;
    int[] positions = new int[separatorNum];
    int[] result = new int[n];
    // shuffle array of o and |
    for (int i = 0; i < separatorNum; i++) {
        int p = (int)(Math.random() * (permutationLength - i)) + i;
        if (p >= separatorNum) {
            // o will be swapped with | if the number was not swapped to | before
            boolean dupe = false;
            for (int j = 0; j < i; j++) {
                if (positions[j] == p) {
                    dupe = true;
                    break;
                }
            }
            positions[i] = (dupe ? i : p);
        } else {
            // another | will be swapped with |, so | will be here
            positions[i] =i;
        }
    }
    // sort the positions
    for (int i = positions.length - 1; i > 0; i--) {
        for (int j = 0; j < i; j++) {
            if (positions[j] > positions[j + 1]) {
                int temp = positions[j];
                positions[j] = positions[j + 1];
                positions[j + 1] = temp;
            }
        }
    }
    // decode the positions
    result[0] = positions[0];
    for (int i = 1; i < n - 1; i++) {
        result[i] = positions[i] - positions[i - 1] - 1;
    }
    result[n - 1] = permutationLength - positions[n - 2] - 1;
    return result;
}