MersenneTwisterFast ran = new MersenneTwisterFast();
    long time = System.nanoTime();
    Set set = new HashSet(100);
    while( set.size()<100) {
        set.add(ran.nextInt(1000000));
   }

System.out.println(System.nanoTime()-time+" : nano");
System.out.println(set.size());