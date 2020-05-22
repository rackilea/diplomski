private static final String GOOD_1 = "[key1:value1,key2:value2,key3:value3],[key21:value21,key22:value22]";
private static final String GOOD_2 = "[key1:value1],[key21:value21]";
private static final String GOOD_3 = "[key1:value1]";
private static final String BAD_1 = "[key1:value1],[key21]";

private static final String KEY_VALUE = "[^:,]+:[^:,]+";
private static final String TOKEN = "\\[" + KEY_VALUE + "(," + KEY_VALUE + ")*\\]";
private static final String REGEX = TOKEN + "(," + TOKEN + ")*";

public static void main (String[] args)
{
    System.out.println("REGEX is " + REGEX);
    System.out.println(GOOD_1 + " is " + check(GOOD_1));
    System.out.println(GOOD_2 + " is " + check(GOOD_2));
    System.out.println(GOOD_3 + " is " + check(GOOD_3));
    System.out.println(BAD_1 + " is " + check(BAD_1));
}

private static boolean check(String str) {
     return str.matches(REGEX);
}