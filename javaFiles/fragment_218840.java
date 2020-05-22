package com.callback;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainCallBack {

    public static void main(String[] args) 
    {

        MainCallBack mainCallBk = new MainCallBack();

        String sCallBackMethodName = "displaySumInTextArea"; //this is the name of the callback method.

        int z = 11 ;
        mainCallBk.displayAnswer( z , sCallBackMethodName );
    }
    private void displayAnswer(Integer answer , String sCallBackMethod)
    {
        try {
            Class className = Class.forName("com.callback.CallBackClass"); //will assume that we know the class name
            Constructor classConstructor = className.getConstructor(); // get the constructor of the class. 
            Object classObject = classConstructor.newInstance(); //create an instance.

            Method[] methods = className.getDeclaredMethods();   //get all methods within the class.

            for (int i = 0; i < methods.length; i++)
            {
                String dataMethod = methods[i].getName();   // iterate through array of methods and get each name
                if(dataMethod.equalsIgnoreCase(sCallBackMethod))  //comparing callbackname with every method in class.
                {
                    methods[i].invoke(classObject, answer);     // invoke the method if they match with what the user is calling.
                                    // if 'displaySumInTextArea( int )' was static then we would use 'null' (without quotes) in place of the classObject.
                }
            }

        } catch (Exception e) {
            e.printStackTrace(); //use specific exceptions here
        }
    }
}