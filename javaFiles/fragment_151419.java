String filePAthDB ="E:/Eclipse-Leo/RD_JMS/src/test/textfile.jpg";
      File f = new File(filePAthDB );
      if(f.exists())
       {
            //process file whatever you want
          System.out.println("Attachment available......");
       }
      else
          System.out.println("not Attachment available......");