if (m == 0 && n > 0) {
        return median(arr2, ->0<-, bEnd);
    }

    if (m > 0 && n == 0) {
        return median(arr1, ->0<-, aEnd);
    }

    if (m == 1 && n == 1) {
        return (double) (arr1[->0<-].getSz() + arr2[->0<-].getSz())/2;
    }