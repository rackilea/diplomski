public class He1 {
    private static final Pattern pattern = Pattern.compile("[a-zA-Z]+(\\d+).*");  
    // match the number between or the last using regx;
    public static void main(String... args) {
        String s = "abc3leson11";
        System.out.println(parse(s));
        s = "abbc2kd3ijkl40ggg2H5uu";
        System.out.println(parse(s));
    }

    private static String parse(String s) {
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            int num = Integer.valueOf(matcher.group(1));
            char prev = s.charAt(s.indexOf(String.valueOf(num)) - 1); 
            // locate the char before the number;
            String repeated = new String(new char[num-1]).replace('\0', prev); 
            // since the prev is not deleted, we have to decrement the repeating number by 1;
            s = s.replaceFirst(String.valueOf(num), repeated);
            matcher = pattern.matcher(s);
        }
        return s;
    }
}