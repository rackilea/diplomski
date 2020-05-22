// create a file to start
      FileOutputStream fo = new FileOutputStream("myfile.txt");
      String alpha = "abcdefghijklmnopqrstuvwxyz";
      fo.write(alpha.getBytes());
      fo.close();

      // create the new output file and open up the old one as an input
      // file
      fo = new FileOutputStream("myfile2.txt");
      FileInputStream fi = new FileInputStream("myfile.txt");
      // insert 123 after k
      byte[] buf = new byte[100];
      int count = fi.read(buf, 0, 11); // read up to and including k
      fo.write(buf, 0, count);
      fo.write("123".getBytes());
      // insert 456 after t
      count = fi.read(buf, 0, 9);
      fo.write(buf, 0, count);
      fo.write("456".getBytes());
      //copy rest of input file to output file
      while ((count = fi.read(buf, 0, 10)) > 0) {
         fo.write(buf, 0, count);
      }
      fo.close();
      fi.close();

      fi = new FileInputStream("myfile2.txt");
      byte[] buffer = fi.readAllBytes();
      for (byte b : buffer) {
         System.out.print((char) b);
      }
      System.out.println();
      fi.close();
   }