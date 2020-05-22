for (int i = 0; i < sorozat.length && !exists; i++) {
        int elem = sorozat[i];
        if (elem < 0) {
            exists = true;
        }
    }