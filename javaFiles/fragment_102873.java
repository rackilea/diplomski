FileOutputStream output = new FileOutputStream("C:\\Users\\Roman\\Desktop\\test2.sav");
     try {
         output.write(bytearray);
     } finally {
         output.close();
     }