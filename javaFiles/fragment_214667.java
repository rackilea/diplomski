public double cal(double x) {
    double x2 = x * x;
    double y_odd = 0.0, y_even = 0.0;
    int index = array_a.length - 1;
    if (index % 2 == 0) {
        y_even = array_a[index];
        index -= 1;
    }
    for (; index >= 0; index -= 2) {
        y_odd = array_a[index] + y_odd * x2;
        y_even = array_a[index-1] + y_even * x2;
    }
    return y_even + y_odd * x;
}