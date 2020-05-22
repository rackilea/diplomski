int length = d.length;
for (int i = 0; i < length - 1; i++) {
    double temp = 0;
    for (int j = length - 1; j > i; j--)
        temp = (temp + d[j]) * t / (j - i);
    d[i] += temp;
}