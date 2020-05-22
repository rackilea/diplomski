double[] set = {0, 0, 0, 0, 0, 1, 2, 2, 3,4,5};

    Arrays.sort(set);

    int from = 0;
    if (set.length % 3==0){
        from = set.length/3*2 ;
    }
    if (set.length % 3 != 0){
        from = Math.round(set.length/3*2) + 1;
    }

    double [] topThirdSet = Arrays.copyOfRange(set,from , set.length);
    DescriptiveStatistics ds = new DescriptiveStatistics(topThirdSet);
    System.out.println(ds.getMean());