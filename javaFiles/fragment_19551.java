public class Test {

    private static final String PATTERN = "\\[/?#(.+?)\\]";
    private static final String TEXT = "Hi, [#if gender=\"Male\"]Mr[#elseif]Mrs[/#if] ${name} I've a special offer for you.";

    public static void main(String[] args) {
        String out = TEXT.replaceAll(PATTERN, "");
        System.out.println(out);
    }

}