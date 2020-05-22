package test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestFooBar {
@SuppressWarnings("rawtypes")
public static void main(String[] args) {
    try {
        // Get the class of interest
        Class fooImpl = Class.forName("test.FooImpl");

        // Test all the methods
        for(Method m : fooImpl.getMethods()) {
            boolean overriden = false;
            List<Class> parents = new ArrayList<Class>();
            for(Class c : fooImpl.getInterfaces()) {
                parents.add(c);
            }
            if(fooImpl.getSuperclass() != null) parents.add(fooImpl.getSuperclass());
            for(Class c : fooImpl.getInterfaces()) {
                for(Method sm : c.getMethods()) {
                    if(equals(sm, m)) {
                        overriden = true;
                        break;
                    }
                }
                if(overriden) break;
            }
            System.out.println(m+": "+(overriden ? "Overriden" : "Not overriden"));
        }
    }
    catch(Exception e) {
        e.printStackTrace();
    }
}

private static boolean equals(Method m1, Method m2) {
    if(!m1.getName().equals(m2.getName())) return false;
    String t1 = "";
    for(Class c : m1.getParameterTypes()) {
        t1+=c.getName()+"/";
    }
    String t2 = "";
    for(Class c : m2.getParameterTypes()) {
        t2+=c.getName()+"/";
    }
    if(!t1.equals(t2)) return false;

    return true;
}
}