for (int i = 1; i <= n; i++) {
    if (n % i == 0) {
        count++;
        System.out.println(i);
    }
}
System.out.println("Number or disivor = " + count);