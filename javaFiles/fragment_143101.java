public static void main (String[] args) throws java.lang.Exception
  {
    String str = "Tyre17x60 Goodyear 458765464"; 
    InputStream is = new ByteArrayInputStream(str.getBytes());
    Scanner sc = new Scanner(is);
    sc.useDelimiter("\n");

    while (sc.hasNext())
    {         
      String[] tmp = sc.next().split("\t");
      if (tmp.length == 3)
         System.out.println("Text contains 3 parts separated with tabs");              
      else
        System.out.println("Text is not well formated");

      // save data 
      //productName = tmp[0];
      //manufacturer = tmp[1];
      //brcode = tmp[2];

    }
  }