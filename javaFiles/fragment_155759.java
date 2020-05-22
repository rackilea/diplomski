Object2 object2 = new Object2();    
    // you need to iniialize ur object2.var2 first
    object2.var2 = new double[][]{ {1.232, 23.233},{3.23,32.12},{3.23,32.12}};
    //or 
    object2.var2 = new double[3][2];
    object2.var2[0][0]=1.232;
    object2.var2[0][1]=23.233;
    object2.var2[1][0]=3.23;
    object2.var2[1][1]=32.12;
    object2.var2[2][0]=3.23;
    object2.var2[2][1]=32.12;

    System.out.println(object2.var2);
    Object1 object1 = new Object1();
    object1.var1= new double[object2.var2.length][2];
    System.out.println(object1.var1);
    System.arraycopy(object2.var2, 0, object1.var1, 0, object2.var2.length);