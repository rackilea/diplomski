public class PersianNumber {
    private static HashMap<Character, String> unicodeMap = new HashMap<>();
    private static HashMap<Character, String> unicodeMapArabic = new HashMap<>();
    private static HashMap<Character, String> unicodeMapViceVera = new HashMap<>();

    static {
        //English/Persian Numbers Map
        unicodeMap.put('0', "\u06F0");
        unicodeMap.put('1', "\u06F1");
        unicodeMap.put('2', "\u06F2");
        unicodeMap.put('3', "\u06F3");
        unicodeMap.put('4', "\u06F4");
        unicodeMap.put('5', "\u06F5");
        unicodeMap.put('6', "\u06F6");
        unicodeMap.put('7', "\u06F7");
        unicodeMap.put('8', "\u06F8");
        unicodeMap.put('9', "\u06F9");

        //English/Arabic Numbers Map
        unicodeMapArabic.put('0',"\u0660");
        unicodeMapArabic.put('1',"\u0661");
        unicodeMapArabic.put('2',"\u0662");
        unicodeMapArabic.put('3',"\u0663");
        unicodeMapArabic.put('4',"\u0664");
        unicodeMapArabic.put('5',"\u0665");
        unicodeMapArabic.put('6',"\u0666");
        unicodeMapArabic.put('7',"\u0667");
        unicodeMapArabic.put('8',"\u0668");
        unicodeMapArabic.put('9',"\u0669");

        //Persian English Numbers Map
        unicodeMapViceVera.put('\u06F0', "0");
        unicodeMapViceVera.put('\u06F1', "1");
        unicodeMapViceVera.put('\u06F2', "2");
        unicodeMapViceVera.put('\u06F3', "3");
        unicodeMapViceVera.put('\u06F4', "4");
        unicodeMapViceVera.put('\u06F5', "5");
        unicodeMapViceVera.put('\u06F6', "6");
        unicodeMapViceVera.put('\u06F7', "7");
        unicodeMapViceVera.put('\u06F8', "8");
        unicodeMapViceVera.put('\u06F9', "9");
        //Arabic English Numbers Map
        unicodeMapViceVera.put('\u0660', "0");
        unicodeMapViceVera.put('\u0661', "1");
        unicodeMapViceVera.put('\u0662', "2");
        unicodeMapViceVera.put('\u0663', "3");
        unicodeMapViceVera.put('\u0664', "4");
        unicodeMapViceVera.put('\u0665', "5");
        unicodeMapViceVera.put('\u0666', "6");
        unicodeMapViceVera.put('\u0667', "7");
        unicodeMapViceVera.put('\u0668', "8");
        unicodeMapViceVera.put('\u0669', "9");
    }

    public static String getPersianNumber(String englishNumber) {
        if (!englishNumber.matches("-?\\d+(\\.\\d+)?")) {
            throw new NumberFormatException("the input [" + englishNumber + "] is not a number!");
        }

        char[] numChars = englishNumber.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < numChars.length; i++) {
            builder.append(unicodeMap.get(numChars[i]));
        }
        return builder.toString();
    }

    public static String getEnglishNumber(String persianNumber) {
        char[] numChars = persianNumber.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < numChars.length; i++) {
            String value = unicodeMapViceVera.get(numChars[i]);
            if(value == null){
                builder.setLength(0);
                builder.append(persianNumber);
                break;
            }
            builder.append(unicodeMapViceVera.get(numChars[i]));
        }
        return builder.toString();
    }

    public static boolean isAPersianNumber(String persianNumber){
        char[] numChars = persianNumber.toCharArray();
        for (int i = 0; i < numChars.length; i++) {
            String value = unicodeMapViceVera.get(numChars[i]);
            if(value == null){
                return false;
            }
        }
        return true;
    }

    public static String convertToStringWithPersianNumber(String input){
        StringBuilder sb = new StringBuilder();

        for(char c : input.toCharArray()){
            String ch = unicodeMap.get(c);
            if(ch != null){
                sb.append(ch);
                continue;
            }
            sb.append(c);
        }

        return sb.toString();
    }

    public static String convertToStringWithEnglishNumber(String input){
        StringBuilder sb = new StringBuilder();

        for(char c : input.toCharArray()){
            String ch = unicodeMapViceVera.get(c);
            if(ch != null){
                sb.append(ch);
                continue;
            }
            sb.append(c);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(getEnglishNumber("۹۶۵۹۴۵۴"));
        System.out.println(getPersianNumber("9999999999999651221"));
        System.out.println(getPersianNumber(59683399623213L + ""));
    }
}