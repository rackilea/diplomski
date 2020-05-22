public static void print(byte[][] bytes) {
    for(byte[] bArray : bytes) {
        StringBuilder binary = new StringBuilder();

        for (byte b : bArray)
          {
             int val = b;
             for (int i = 0; i < 8; i++)
             {
                binary.append((val & 128) == 0 ? 0 : 1);
                val <<= 1;
             }
             binary.append(' ');
          }

        System.out.println(binary.toString());
    }
}