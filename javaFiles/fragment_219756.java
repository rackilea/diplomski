public static void main(String[] args) throws IOException
  {
    System.out.println("START PROGRAM");
    long start = System.currentTimeMillis();
    try
    {

      Process p = Runtime.getRuntime().exec("raspivid -w 100 -h 100 -n -t 10000 -o -");
      BufferedInputStream bis = new BufferedInputStream(p.getInputStream());
      //Direct methode p.getInputStream().read() also possible, but BufferedInputStream gives 0,5-1s better performance
      FileOutputStream fos = new FileOutputStream("testvid.h264");

      System.out.println("start writing");
      int read = bis.read();
      fos.write(read);

      while (read != -1)
      {
        read = bis.read();
        fos.write(read);
      }
      System.out.println("end writing");
      bis.close();
      fos.close();

    }
    catch (IOException ieo)
    {
      ieo.printStackTrace();
    }
    System.out.println("END PROGRAM");
    System.out.println("Duration in ms: " + (System.currentTimeMillis() - start));
  }