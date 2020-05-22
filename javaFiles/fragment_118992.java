final int TRIALS = 100;
    int same = 0;//check if they are the same??
    int aux = 0;
    for(int i=0; i<TRIALS; i++){
        aux = 0;
        int a = rand.nextInt(6)+1;
        int b = rand.nextInt(6)+1;
        int c = rand.nextInt(6)+1;
        int d = rand.nextInt(6)+1;
        int e = rand.nextInt(6)+1;
        if(a == b || a == c || a == d || a == e)
            aux++;
        if(b == c || b == d || b == e)
            aux++;
        if(c == d || c == e)
            aux++;
        if(d == e)
            aux++;
        if(aux > 2)
            same++;
    }
    double prob = same/TRIALS;
    System.out.println("The posibilities are: " + prob);
}