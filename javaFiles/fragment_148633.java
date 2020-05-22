public class Foo
{
    public final int smth;
    public final Integer smthElse;

    public Foo(JSONObject myObj) {
        int smthValue = 1;
        Integer smthElseValue = 2;

        if(myObj != null) try {
            int extraParam = Integer.parseInt("ABCD"); //This is just an example
            smthValue = extraParam;
            smthElseValue = extraParam;
        } catch (Exception e) {}

        smth = smthValue;
        smthElse = smthElseValue;
    }
}