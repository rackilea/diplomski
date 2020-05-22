for(int i = 0;i < limit;i++){
    int ar[]=new int[pairSize]; //create a new one at each iteration
    for(int j = 0;j < pairSize;j++){
       ar[j]=randomNo(max,min);
       System.out.print(ar[j]);
    }
    test.add(ar);
    System.out.println();
}