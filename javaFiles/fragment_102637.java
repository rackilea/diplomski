public class IntToSetNotationRecursive {
    private static final String openBrace = "{";
    private static final String closeBrace = "}";
    private static final String separator = ",";

    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            System.out.println(i + " = " + getSetNotationFromInt(i));
        }
    }

    static String getSetNotationFromInt(int n){
        return helper1(n, n, "");
    }

    static String helper1(int n, int x, String s){
        if(x<=0)
            return openBrace + s + closeBrace;

        return helper1(n, x-1, helper1(x-1,x-1,"") + ((x != n ) ? separator : "") + s);
    }
}