int count;
int value;
   for (int i=65; i<91; i++) {
      count=0;
      for (int j=0; j<S.length; j++) {
      value=(int)S[j];
      if (value == i) {
         count++;
      }
   }
   if (count>0) 
      System.out.println((char)i+" -- "+count);
}