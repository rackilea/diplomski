private static int positiveDiff = 'A' - '1';
    private static int negativeDiff = 'J' - '1';

    private static char positive0EbcdicZoned = '{';
    private static char negative0EbcdicZoned = '}';

    public static String fromZoned(String numZoned) {
        String ret;
        String sign = "";
        char lastChar, ucLastChar;

        if (numZoned == null || ((ret = numZoned.trim()).length() == 0) || ret.equals("-")) {
            return "";
        }

        lastChar = ret.charAt(ret.length() - 1);
        ucLastChar = Character.toUpperCase(lastChar);


        switch (ucLastChar) {
        case 'A': case 'B': case 'C': 
            case 'D': case 'E': case 'F':
            case 'G': case 'H': case 'I':
            lastChar = (char) (ucLastChar - positiveDiff);
            break;
        case 'J': case 'K': case 'L':
        case 'M': case 'N': case 'O':
        case 'P': case 'Q': case 'R':
            sign = "-";
            lastChar = (char) (ucLastChar - negativeDiff);
            break;
        default:
            if (lastChar == positive0EbcdicZoned) {
                lastChar = '0';
            } else if (lastChar == negative0EbcdicZoned) {
                lastChar = '0';
                sign = "-";
            }           
        }
        ret = sign + ret.substring(0, ret.length() - 1) + lastChar;

         return ret;
    }