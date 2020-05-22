public class Solution {
    private static final char[] digits = "0123456789abcdef".toCharArray(); 

    public String toHex(int num) {
        if (num == 0) return "0";

        StringBuilder buffer = new StringBuilder();
        while (num != 0) {
            buffer.append(digits[num & 0xF]);
            num = num >>> 4;
        }
        return buffer.reverse().toString();
    }
}