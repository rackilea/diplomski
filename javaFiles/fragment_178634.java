Vector<Vector<Double>>  matrix= new Vector<Vector<Double>>();

    for(int i=0;i<2;i++){
        Vector<Double> r=new Vector<>();
        for(int j=0;j<2;j++){
            r.add(Math.random());
        }
        matrix.add(r);
    }
    for(int i=0;i<2;i++){
        Vector<Double> r=matrix.get(i);
        for(int j=0;j<2;j++){
            System.out.print(r.get(j));
        }
        System.out.println();
    }