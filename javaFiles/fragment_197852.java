public static int makeChange(int amount, int[] d) { 
    if (amount < 0) return 0;
    if (amount == 0) return 1;
    int i = 0;
    for (i = 0; i < d.length; i++) { 
        if (d[i] != 0) break;
    }
    if (i == d.length) return 0;
    int num1 = makeChange(amount-d[i],d);
    int temp = d[i];
    d[i] = 0;
    int num2 = makeChange(amount,d);
    d[i] = temp;
    return num1 + num2;
}