int count = 0;
 int b = 0;
 while ((b=stream.read()) !=-1) 
 {
   fos.write(b);
   count++;
 }