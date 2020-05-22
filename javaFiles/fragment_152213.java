public static void getFibbSeries(int limit) {
    int f1 = 1;
    int f2 = 1;
    System.out.print(f1 + " " + f2); //print first 2 Fibbonaci 

    int curFib = f1 + f2;            // Fn+1 = Fn-1 + Fn
    while(curFib < limit) {
        System.out.print(" " + curFib);
        f1 = f2;
        f2 = curFib;
        curFib = f1 + f2;           // this is current fibbonaci number 
    }

}