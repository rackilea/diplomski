int m=1;
    for(int i=1; i<=5; i++){
        for(int j=m;j<=i+m-1;j++){
            System.out.print(j+" ");                              
        }

        for(int k=i+m-3;k>=m-1;k--){
            System.out.print(k+1+" ");
        }        

        System.out.println();
        m++;
    }