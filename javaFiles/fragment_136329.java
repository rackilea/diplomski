String nameOfFile = "D:\\abckjk.csv";
   try {   
      PrintWriter pw = new PrintWriter(new FileOutputStream(nameOfFile));
      pw.println(str);
      //clean up
      pw.close();
   } catch(IOException e) {
      out.println(e.getMessage());
   }