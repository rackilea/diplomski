Random r = new Random();
    for (int i = 0; i < maxSize; i++) {
        int j = r.nextInt(i + 1);
        if (j != i) {
            array[i] = array[j];
        }
        array[j] = i + 1;
    }