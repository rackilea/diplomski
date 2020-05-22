DecimalFormat format = new DecimalFormat("###.##");

    double[] doubles = {123.45, 99.0, 23.2, 45.0};
    for(int i=0;i<doubles.length;i++){
        System.out.println(format.format(doubles[i]));
    }