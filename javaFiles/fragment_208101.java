public class Solution {
    private static final char[] digits = "0123456789abcdef".toCharArray(); 

    private Stack<Integer> stack = new Stack<>();
    public String toHex(int num) {
        if (num == 0) return "0";

        stack.clear();
        while (num != 0) {
            stack.push(num & 0xF);
            num = num >>> 4;
            if (stack.size() > 8) break;
        }

        StringBuilder buffer = new StringBuilder();
        while (!stack.empty()) {
            buffer.append(digits[stack.pop()]);
        }

        return buffer.toString();
    }
}