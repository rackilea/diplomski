File[] concat(File[] A, File[] B) 
   {
     File[] C= new File[A.length+B.length];
     System.arraycopy(A, 0, C, 0, A.length);
     System.arraycopy(B, 0, C, A.length, B.length);
     return C;
   }