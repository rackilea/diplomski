public static void main(String[] args) {

        int checkSum = 0;
        byte [] bytes = hexStringToByteArray("09F7F8008100000FFF");

          for(byte b : bytes){
            checkSum += (0xff & b);
          }

          String checkSumHex = Integer.toHexString(checkSum & 0xFF);

          System.out.println("Checksum is: "+ checkSumHex);
    }

    private static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }