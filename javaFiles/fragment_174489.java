package br;
import java.lang.reflect.Field;

final class R {
    public static final class string {
        public static final int alt_string1=0x7f060601;
        public static final int alt_string2=0x7f060101;
    }
}
public class StaticReflection {

    public static boolean globalVariable = false;

    //this would be android method getString
    public static String fakeGetString(int id){
        switch (id){
        case R.string.alt_string1: return "it";
        case R.string.alt_string2: return "works";
        default:
            return "O NOES";
        }
    }

    //static method
    public static String getResource(String resId) throws Exception {
        if (globalVariable){
            resId += "string1";
        } else {
            resId += "string2";
        }
        Field f = R.string.class.getDeclaredField(resId);
        Integer id = (Integer) f.get(null);
        return fakeGetString(id);
    }

    public static void main(String[] args) throws Exception {
        globalVariable=true;
        System.out.println(getResource("alt_"));
        globalVariable=false;
        System.out.println(getResource("alt_"));
    }
}