public static String hexToBinary(String hex) throws IOException {
    String result = "";
    String binVal; // the binary value of the Hex
    for (int i = 0; i < hex.length(); i++) {
        char hexChar = hex.charAt(i);

        switch (hexChar) {
            case ('0'):
                binVal = "0000";
                break;
            case ('1'):
                binVal = "0001";
                break;
            case ('2'):
                binVal = "0010";
                break;
            case ('3'):
                binVal = "0011";
                break;
            case ('4'):
                binVal = "0100";
                break;
            case ('5'):
                binVal = "0101";
                break;
            case ('6'):
                binVal = "0110";
                break;
            case ('7'):
                binVal = "0111";
                break;
            case ('8'):
                binVal = "1000";
                break;
            case ('9'):
                binVal = "1001";
                break;
            case ('A'):
                binVal = "1010";
                break;
            case ('B'):
                binVal = "1011";
                break;
            case ('C'):
                binVal = "1100";
                break;
            case ('D'):
                binVal = "1101";
                break;
            case ('E'):
                binVal = "1110";
                break;
            case ('F'):
                binVal = "1111";
                break;
            default:
                binVal = "invalid input";
                break;
        }
         result += binVal;
    }
    return result;
  }