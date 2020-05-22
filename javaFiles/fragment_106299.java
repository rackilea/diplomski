public class PatternIncorrect {

    public static void main(String[] args) {
        System.out.println("------Test 1------------- ");
        System.out.println(test1("0x4F 0xBB 0x74 0xA9"));
        System.out.println("------Test 2--------------");
        System.out.println(test2("0x4F 0xBB 0x74 0xA9"));
        System.out.println("------Test 3--------------");
        List<String> test3 = test3("0x4F 0xBB 0x74 0xA9asdasd0x4F 0xBB 0x74 0xA9mfdskf0x4F 0xBB 0x74 0xA9");
        for(String t : test3) {
            System.out.println(t);
        }
    }

    public static boolean test1(String str) {
        List<String> strings = Arrays.asList(str.split(" "));
        boolean isMatch = true;
        String regEx = "0x[1-9][ABCDEF]|0x[ABCDEF][1-9]|0x[1-9][1-9]|0x[ABCDEF][ABCDEF]";
        for (String s : strings) {
            if (!s.matches(regEx)) {
                System.out.println(s);
                isMatch = false;
                break;
            }
        }
        return isMatch;
    }

    public static boolean test2(String s) {
        String regEx = "0x[A-F1-9]{1,2} 0x[A-F1-9]{1,2} 0x[A-F1-9]{1,2} 0x[A-F1-9]{1,2}";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(s);
        return matcher.find();
    }

    public static List<String> test3(String s) {
        String regEx = "0x[A-F1-9]{1,2} 0x[A-F1-9]{1,2} 0x[A-F1-9]{1,2} 0x[A-F1-9]{1,2}";
       return Arrays.asList(s.split(regEx));
    }
}