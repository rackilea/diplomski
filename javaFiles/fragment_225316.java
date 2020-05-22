public int findElement() throws IndexingError {
    int[] bigArray = getArray();
    int k = getIndex();
    if (k <= 0 || k > bigArray.length) {
        throw new IndexingError();
    }

    int[] smallArray = Arrays.copyOfRange(bigArray,0,k);
    Arrays.sort(smallArray);


    for (int i = k; i < bigArray.length; i++) {
        if(bigArray[i] > smallArray[0]) {
            smallArray[0] = bigArray[i];
            int j = 0;
            while((j < k-1) && (smallArray[j] > smallArray[j+1])) {
                swap(smallArray[j], smallArray[j+1]);
                j++;
            }
        }

    }

    return smallArray[0];
}