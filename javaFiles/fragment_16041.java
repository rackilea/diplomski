private static int[] merge(int[] a, int[] b){
    int[] res = new int[a.length + b.length];
    int ia = 0;
    int ib = 0;
    int i = 0;
    while(ia < a.length && ib < b.length){
        if(a[ia] < b[ib]) {
            res[i] = a[ia];
            ia++;
            i++; 
        }
        else {
            res[i] = b[ib];
            ib++;
            i++;
        }
    }

    if (ia < a.length) {
        for (int k = ia; k < a.length; k++) {
            res[i] = a[k];
            i++;
        }
    }
    if (ib < b.length) {
        for (int k = ib; k < b.length; k++) {
            res[i] = b[k];
            i++;
        }
    }
    return res;
}