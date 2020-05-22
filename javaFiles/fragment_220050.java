for (int i = 0; i < n-1; i++) {
    for (int j = i + 1; j < n; j++) {
        if (priya[i].compareTo(priya[j]) > 0) {
            String temp = priya[i];
            priya[i] = priya[j];
            priya[j] = temp;
        }
    }
}