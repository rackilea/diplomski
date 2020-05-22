public class StringBufferUse {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        sb.append("a");
        sb.append("b");
        sb.append(123);
        System.out.println(sb.toString()); /* prints "ab123" */
    }
}