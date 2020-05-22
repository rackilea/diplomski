package com.reflect.main;

import java.lang.reflect.Method;

public class ReflectApp {

  public static void main(String[] args) {

    Class noparams[] = {};

    try{
      //load the Reflect at runtime
      Class cls = Class.forName("com.reflect.Reflect");
      Object obj = cls.newInstance();

      //call the testMethod method
      Method method = cls.getDeclaredMethod("testMethod", noparams);
      method.invoke(obj, null);
    } catch(Exception ex) {
      ex.printStackTrace();
    }
  }
}