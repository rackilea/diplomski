package com.trip.test;

import java.util.HashMap;
import java.util.Map;

public class ExampleFactory {

    private static Map<String, Class<?>> hmap = new HashMap<String, Class<?>>();

    static {
        hmap.put("echo", EchoExpression.class);
        hmap.put("Out", OutExpression.class);
    }

    public static void getExpo(String key, String expression) {

        Class aClass = hmap.get(key);

        ClassMappingEnum myType = ClassMappingEnum.getClassMappingEnum(aClass);

        switch (myType) {
        case ECHO_EXPRESSION:{
            System.out.println(aClass.getName());
            // do something
            break;
        }
        case OUT_EXPRESSION:{
            System.out.println(aClass.getName());
            // do something
            break;          
        }
        case UNKNOWN:
        default:
            System.out.println("Bummer: " + aClass.getName());          
        }

    }

    public static void main(String[] args) {
        getExpo("echo", "B");
        getExpo("Out", "B");
    }   
}

enum ClassMappingEnum {
    ECHO_EXPRESSION(EchoExpression.class), OUT_EXPRESSION(OutExpression.class), UNKNOWN(null);

    private Class typeDes;

    private ClassMappingEnum(Class typeDes) {
        this.typeDes = typeDes;
    }

    public static ClassMappingEnum getClassMappingEnum(Class compare) {
        for (ClassMappingEnum cme : ClassMappingEnum.values()) {
            if (cme.typeDes.equals(compare)) {
                return cme;
            }
        }
        return UNKNOWN;
    }


}

class EchoExpression<T> {
    private String someString;
    private Class<T> someClass;
    public EchoExpression(String someString, Class<T> someClass) {
        super();
        this.someString = someString;
        this.someClass = someClass;
    }
    public String getSomeString() {
        return someString;
    }
    public void setSomeString(String someString) {
        this.someString = someString;
    }
    public Class<T> getSomeClass() {
        return someClass;
    }
    public void setSomeClass(Class<T> someClass) {
        this.someClass = someClass;
    }


}

class OutExpression {
    private String someString;

    public OutExpression(String someString) {
        super();
        this.someString = someString;
    }

    public String getSomeString() {
        return someString;
    }

    public void setSomeString(String someString) {
        this.someString = someString;
    }

}