for (int i = 0, ctr = 0; i < x.length; ctr++) {
    System.out.print("[ ");
    for (int j = 0; j <= ctr; i++) {
        System.out.print(x[i]);
        j++;
        if (j <= ctr) {
            System.out.print(" ,");
        }
    }
    System.out.println(" ]");
}