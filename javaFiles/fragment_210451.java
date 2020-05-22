public void run() {
    for (int i=0; i<5 ; i++) {
        for (int j=0; j<5-i-1 ; j++) {
            System.out.print(".");
        }

        System.out.print(i+1);
        //Run another loop
        for (int k=0; k<i ; k++) {
            System.out.print(".");
        }
        System.out.println();
    }
}