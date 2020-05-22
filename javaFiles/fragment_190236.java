while (j > 0 && temp <= a[j - 1]) {
    if(temp == a[j - 1]) temp = -1;
    a[j] = a[j - 1];

    j--;
}