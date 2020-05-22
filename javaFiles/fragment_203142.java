int a[][] = new int [4][4];
    int i,j;
    int s = 0;
    int len=a.length-1;

    for(i= 0;i<a.length; i++)
        for(j = 0; j<a[i].length; j++){
            a[i][j] = (int)(Math.random()*10);
        }
         System.out.println("Original matrix\n");   
    for(i=0;i<a.length;i++){
        for(j=0;j<a[i].length;j++)

        System.out.print(a[i][j] + "\t");
        System.out.println();   
    }
    for(i=0;i<a.length;i++){
        for(j=0;j<a[i].length;j++)
            if(!((i==0)||(j==0)||(j==len)||(i==len))){
                a[i][j]=1;
            }

    }
  System.out.println("\nConverted matrix\n");   
   for(i=0;i<a.length;i++){
        for(j=0;j<a[i].length;j++)

        System.out.print(a[i][j] + "\t");
        System.out.println();   
    }