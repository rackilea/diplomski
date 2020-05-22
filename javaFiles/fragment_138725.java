int pag_size = 4;
    int pag_array_size=pag_size*4;


    int[] pag = new int [pag_size];
    int[] marc = {5, 6, 1, 2};
    int[] calc1 = new int[pag_array_size];

    for(int i=0;i<pag.length;i++){
           pag[i]=i;
    }

    for (int i = 0 ; i <  pag_array_size; i++){
        calc1[i] = marc[i/pag_size]* pag_size  + pag[i%pag_size];
        System.out.println(calc1[i]);
    }