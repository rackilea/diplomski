public class BinaryArithmetic {
    static String[] lookupTable = {
        "0+0+0=00",
        "0+0+1=01",
        "0+1+0=01", 
        "0+1+1=10",
        "1+0+0=01",
        "1+0+1=10",
        "1+1+0=10",
        "1+1+1=11",
    };
    static String lookup(char b1, char b2, char c) {
        String formula = String.format("%c+%c+%c=", b1, b2, c);
        for (String s : lookupTable) {
            if (s.startsWith(formula)) {
                return s.substring(s.indexOf("=") + 1);
            }
        }
        throw new IllegalArgumentException();
    }
    static String zeroPad(String s, int length) {
        while (s.length() < length) {
            s = "0" + s;
        }
        return s;
    }   
    static String add(String s1, String s2) {
        int length = Math.max(s1.length(), s2.length());
        s1 = zeroPad(s1, length);
        s2 = zeroPad(s2, length);
        String result = "";
        char carry = '0';
        for (int i = length - 1; i >= 0; i--) {
            String columnResult = lookup(s1.charAt(i), s2.charAt(i), carry);
            result = columnResult.charAt(1) + result;
            carry = columnResult.charAt(0);
        }
        if (carry == '1') {
            result = carry + result;
        }
        return result;
    }
    public static void main(String args[]) {
        System.out.println(add("11101", "1001"));
    }
}