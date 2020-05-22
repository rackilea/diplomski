import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Test {    
    public static void initObject(Object o) throws Exception {
        if (!(o instanceof ObjA)&&!(o instanceof ObjB)) return;
        Method m = o.getClass().getMethod("setCounter",java.math.BigInteger.class);
        m.invoke(o,BigInteger.ZERO);
        m = o.getClass().getMethod("setData",java.lang.String.class);
        m.invoke(o,"");
    }

    public static void main(final String[] args) throws Exception {
        List<Object>objects = new ArrayList<Object>();
        //this is like your factory method
        Object o = Class.forName("ObjA").newInstance();
        initObject(o);
        objects.add(o);
        o = Class.forName("ObjB").newInstance();
        initObject(o);
        objects.add(o);
    }
}