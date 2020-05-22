public Complex smallest(Complex[] arr) {
    if (arr.length == 0) return null;

    Complex min = arr[0];

    for (int i = 1; i < arr.length; i++) {
        if (arr[i].getReal() < min.getReal()) {
            min = arr[i];
        } else if (arr[i].getReal() == min.getReal()) {
            if (arr[i].getImaginary() < min.getImaginary()) {
                min = arr[i];
            }
        }
    }
    return min;
}