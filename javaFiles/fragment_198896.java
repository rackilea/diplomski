a[0] = 1;
for (int i = 1; i <= n; i++) {
    int carry = 0;
    for(int j = 0; j < a.length; j++) {
        int x = a[j] * i + carry;
        a[j] = x % 10;
        carry = x / 10;             
    }
}