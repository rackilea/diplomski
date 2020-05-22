public static void main(String[] args) throws IOException {

      InputStream is = null;
      DataInputStream dis = null;
      int count = 0;
      byte[] bs = null;
      String content = "";

      try{

         is = new FileInputStream("C:\\test.txt");

         dis = new DataInputStream(is);

         count = is.available();

         bs = new byte[count];

         dis.read(bs);

// here is a variable that contains the buffer content as a String
         content = new String(bs);
      } catch (IOException e) {

      } finally {
          is.close();
          dis.close();
      }
      System.out.println(content);
}