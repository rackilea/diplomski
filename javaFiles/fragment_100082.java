int result = 1;
if (n>k && k>0) {
    int i = k+1;
    while (i<=n) {
        result *=i;
        i++;
    }
    System.out.println("n!/k!=" + result );
}