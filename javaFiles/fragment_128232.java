byte buff[] = new byte[ (int) (image.total() * image.channels())];

 int a;
 int b;
 double picdata[][] =  new double[10][10] ;
 double[] temp;

 for (a=0 ; a<10;a++){
     for (b=0 ; b<10;b++){
         temp=   image.get(a, b);
         picdata[a][b]=temp[0]; 

     }
 }