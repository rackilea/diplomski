ArrayList<Integer[]> b= new ArrayList<Integer[]>();
    Integer[] a= new Integer[2];
    for(Integer i=0;i<20;i++){
        a[0]=i;
        a[1]=i;
        b.add(a);
    }
    for(int i=0;i<20;i++){
        System.out.println("line"+i+"= "+b.get(i)[0]+" "+b.get(i)[1]);
    }