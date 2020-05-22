public class BinToHex {

    static char[] HEX = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
    static int[] POW_2 = {1,2,4,8};
    public static String toHex(String bin) {
        int len = bin.length();
        char[] result = new char[(int)Math.ceil(len*1D/4)];
        int pos = result.length-1;
        int hexval = 0;
        for (int i=0; i<len;i++ ){
            hexval += (bin.charAt(len-i-1)-HEX[0]) * POW_2[i%4];
            if ((i+1)%4==0) {
                result[pos--] = HEX[hexval];
                hexval = 0;
            }
        }
        if (pos==0) {
            result[0] = HEX[hexval];
        }
        return new String(result);
    }

    public static void main(String [] param) {
        System.out.println(BinToHex.toHex("1")); // border case 1 char => 0x1
        System.out.println(BinToHex.toHex("101")); // testcase less than 4 chars => 0x5
        System.out.println(BinToHex.toHex("1011")); // testcase eq 4 chars => 0xB
        System.out.println(BinToHex.toHex("101101011011")); // testcase lenght % 4  = 0
        System.out.println(BinToHex.toHex("11101101011011")); // testcase lenght % 4  != 0
        System.out.println(BinToHex.toHex("000101101011011")); // testcase leading 0
    }

}