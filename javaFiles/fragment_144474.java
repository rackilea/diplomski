public static void main(String[] args) 
           throws NoSuchAlgorithmException, UnsupportedEncodingException {
      Key key;
      SecureRandom rand = new SecureRandom();
      KeyGenerator generator = KeyGenerator.getInstance("AES");
      generator.init(rand);
      generator.init(256);
      key = generator.generateKey();
      String key1 = key.toString();
      byte[] genratesessionKey1 = key1.getBytes();
      System.out.println("SESSION KEY IS(Byte format)   " 
                             +  genratesessionKey1.toString());

      String test2="yadav";
      byte[] g2 = test2.getBytes("UTF-8");
      byte[] g3 = test2.getBytes();              
      System.out.println("Session key in String   " + key1);
      System.out.println("Testing Byte Format   " + g2);
      System.out.println("Testing Byte Format 2   " + g3);

      System.out.println("Session key in String   "
                                     + Arrays.toString(genratesessionKey1));

   } // main(String[])