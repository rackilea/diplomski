char alpha[] = {'A', 'B', 'C'};
for (int m = 1 ; m != 1<<alpha.length ; m++) {
    for (int i = 0 ; i != alpha.length ; i++) {
        if ((m & (1<<i)) != 0) {
            System.out.print(alpha[i]);
        }
    }
    System.out.println();
}