private void benchMark(){

    long t, t1=0, t2 =0;

    for (int i =0; i< 50; i++){
        t= System.currentTimeMillis();
        method1();
        t1 += System.currentTimeMillis()-t;


        t= System.currentTimeMillis();
        method2();
        t2+= System.currentTimeMillis()-t;
    }


    System.out.println("Benchmarking\n\tMethod 1 took + "+t1+" ms\n\tMethod 2 took "+t2+" ms");
}