int num = 2500000;
long sum = 0;
boolean[] arr = new boolean[num];
for (int p = 2; p < num; p++) {
    if (!arr[p]) {
        sum += p;
        for (int k = p * 2; k < num; k += p)
            arr[k] = true;
    }
}
System.out.println(sum);