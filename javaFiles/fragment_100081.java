int kfactorial = 1;
int nfactorial = 1;
if (n>k && k>0) {
    int i = 1;
    while (i<=k) {
        nfactorial *=i;
        kfactorial *=i;
        i++;
    }
    while (i<=n) {
        nfactorial *=i;
        i++;
    }
    System.out.println("n!/k!=" + nfactorial/kfactorial );
}