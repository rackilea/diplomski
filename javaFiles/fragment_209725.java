for (int i = 0; i < n; i++) {
    int c = (a[i] >> BITS_PER_BYTE*d) & MASK;
    aux[count[c]++] = a[i];
}

for (int i = 0; i < n; i++)
    a[i] = aux[i];