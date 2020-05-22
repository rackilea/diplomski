for (int i = sorozat.length - 1; i > 0; i--) {
        for (int j = 0; j < i; j++) {
            if (sorozat[j] > sorozat[j + 1]) {
                int tmp = sorozat[j];
                sorozat[j] = sorozat[j + 1];
                sorozat[j + 1] = tmp;
            }
        }
    }