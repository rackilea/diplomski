int maxValue = num[0];
    int getMaxIndex = 0;
    for (int i = 1; i < num.length; i++) {
        if (num[i] > maxValue) {
            maxValue = num[i];
            getMaxIndex = i;
        }
    }