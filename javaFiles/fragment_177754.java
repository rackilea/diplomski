package com.stackoverflow.q2169497;

import java.io.Serializable;
import java.lang.reflect.Method;

public class Test {

    public String doSomething(Serializable serializable) {
        return serializable.toString();
    }

    public static void main(String[] args) throws Exception {
        Test test = new Test();
        for (Method method : test.getClass().getMethods()) {
            if ("doSomething".equals(method.getName())) {
                if (method.getParameterTypes()[0].isAssignableFrom(String.class)) {
                    System.out.println(method.invoke(test, "foo"));
                }
            }
        }
    }

}