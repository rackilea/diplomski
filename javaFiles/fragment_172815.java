public class Example {

    private String str1 = null;
    private String str2 = null;

    public static void main(String[] args) {
        Example e = new Example(args[0], args[1]);
        String req = e.getRequired();
        System.out.println(req);
    }

    private Example(String a, String b) {
        str1 = new String(a);
        str2 = new String(b);
    }

    String getStr1() {
        return str1;
    }

    String getStr2() {
        return str2;
    }

    private String getRequired() {
        //code using str1 and str2 here
        return "success";
    }

    public static Example getNewInstance(String a, String b) {
        return new Example(a, b);
    }
}