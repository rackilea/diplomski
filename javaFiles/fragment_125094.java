public static int addingNumbers(int[] a) {
    int i1 = -1, i2 = -1;

    for(int i = 0; i < a.length ; i++) {
            for(int j = i+1; j < a.length ; j++) {
                if(a[i] + a[j] == 4) { // index 0 and index 2 when added gives you a sum 4
                    i1 = i;
                    i2 = j;
                }
            }
    }   
    if(i1>=0 && i2 >=0) {
        System.out.println("The indices are " + i1 + " and " + i2);
    }
    return i1;
}