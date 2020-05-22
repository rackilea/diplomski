private void calculatepar(double v1[], double v2[]) {
    for (double z : v1)
        sumv1 += z;
    for (double z : v2)
        sumv2 += z;

    double avrx = sumv1 / n;
    double avry = sumv2 / n;

    for (int i = 0; i < n; i++)
        v3[i] = (v1[i] - avrx);
    for (int i = 0; i < n; i++) {
        sumv32 += Math.pow(v3[i], 2);
    }
    for (int i = 0; i < n; i++) {
        sumv34 += Math.pow(v3[i], 4);
    }
    for (int i = 0; i < n; i++) {
        sumv3v2 += v3[i] * v2[i];
    }
    for (int i = 0; i < n; i++) {
        sumv32y += (Math.pow(v3[i], 2)) * v2[i];
    }

    c = ((n * sumv32y) - (sumv2 * sumv32)) / ((n * sumv34) - (Math.pow(sumv32, 2)));
    b = sumv3v2 / sumv32;
    a = ((sumv2 * sumv34) - (sumv32 * sumv32y)) / ((n * sumv34) - (Math.pow(sumv32, 2)));
}