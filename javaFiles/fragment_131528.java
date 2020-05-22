public class Test {
    public static void main(String[] args) {
        String text = "0x009a";

        // Remove the leading "0x". You may want to add validation
        // that the string really does start with 0x
        String textWithoutPrefix = text.substring(2);
        short value = Short.parseShort(textWithoutPrefix, 16);
        System.out.println(value);
    }
}