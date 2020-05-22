class Example
{
    private static String regex = "^(?:VM|VF|TV|IM|IF)(?:;(?:VM|VF|TV|IM|IF))*$";

    public static void main (String[] args) throws java.lang.Exception
    {
        test("VF;VM", true);
        test("VF;GM", false);
        test("VF,VM", false);
        test("VF;VM;IF", true);
        test("VF,VM;IF", false);
    }

    private static void test(String str, boolean expectedResult) {
        boolean result = str.matches(regex);
        System.out.println(str + " -- " + (result ? "Good" : "Bad") + (result == expectedResult ? " - OK" : " - ERROR"));
    }
}