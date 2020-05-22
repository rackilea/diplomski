for(int i = 9; i>=0; i--){
    boolean right = (i%2 == 0);
    for(int j = (right?1:10); j!=0 && j!=11; j = j + (right?1:-1)){
        System.out.print(i*10 + j);
        System.out.print("\t");

    }
    System.out.println();
}