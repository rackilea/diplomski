int[] input = //...
int[] input = new int[]{2, 6, 7, 3, 9};
Integer[] indices = new Integer[input.length];
for (int i = 0; i < indices.length; i++) {
    indices[i] = i;
}

// find permutation of indices that would yield sorted input
Arrays.sort(indices, Comparator.comparingInt(i -> input[i]));

// invert permutation and add 1 to get rank 
int[] ranks = new int[indices.length];
for (int i = 0; i < indices.length; i++) {
    ranks[indices[i]] = i+1;
}