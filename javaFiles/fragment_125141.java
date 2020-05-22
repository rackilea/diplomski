Component A[]=this.getContentPane().getComponents();
     int y = A.length;
     for(int i=0;i<y;i++){
     System.out.println(A[i]);
     A[i].setFont(new java.awt.Font("Trajan Pro",3, 18));
     }