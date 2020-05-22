int read =0;
   int reddit = 0;
   byte[] bytes = new byte[1024];
   while((read = dis.read(bytes)) != -1)
   {
        fos.write(bytes, 0, read);
        reddit += read;
   }
   //your read variable must have the value -1 at this point
   System.out.println(reddit + " byte(s) copied");