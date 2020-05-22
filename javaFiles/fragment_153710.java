double[][] first= new double[5][3];
    double[][] second= new double[5][3];
    for(int i=0; i<first.length; i++){
        for(int j=0; j<first[i].length; j++){
            first[i][j] = 5;
        }
    }
    for(int i=0; i<second.length; i++){
        for(int j=0; j<second[i].length; j++){
            second[i][j] = 5;
        }
    }
    second[4][2] = 2;

    MyClass c1 = new MyClass(first);
    MyClass c2 = new MyClass(second);

    System.out.println("Equals: "+c1.equals(c2));