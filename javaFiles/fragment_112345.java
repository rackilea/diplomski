package test.mytest;

import org.slf4j.Logger/*INTERFACE*/;
import org.slf4j.LoggerFactory/*CLASS*/;
import test.mytest.MyEnum/*ENUM*/;
import static test.mytest.MyEnum.*;

@interface MyAnnotation/*ANNOTATION_TYPE*/ { }

interface MyInterface/*INTERFACE*/ { }

class MyClass/*CLASS*/ { }

public class App/*CLASS*/ {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    private static final String STR1 = "test";

    private StringBuilder sb10 = new StringBuilder();

    //super/*FIELD*/
    //this/*FIELD*/

    public <T/*TYPE_PARAMETER*/> void test(T obj/*PARAMETER*/) {
        MyEnum e/*LOCAL_VARIABLE*/ = TEST1;
        switch (e) {
            case TEST1:
                StringBuilder sb/*LOCAL_VARIABLE*/ = new StringBuilder();
                StringBuilder sb1/*LOCAL_VARIABLE*/ = new StringBuilder();
                obj = null;
                if (obj == TEST1) { }
                try {
                    obj.toString();
                } catch (NullPointerException npe/*EXCEPTION_PARAMETER*/) {
                    StringBuilder sb3/*LOCAL_VARIABLE*/ = new StringBuilder();
                    final String str/*LOCAL_VARIABLE*/ = "hi!";
                    LOGGER.debug(STR1);
                }
            default:
                break;
        }
    }

    public static void main(String[] args) {
        new App().<String>test("test");
    }
}