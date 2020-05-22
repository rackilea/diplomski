package com.sree;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.sree.test.CreateFile;

public class Test {
    public static void main(String[] args) throws SecurityException,
            NoSuchMethodException, IllegalArgumentException,
            InstantiationException, IllegalAccessException,
            InvocationTargetException {
        Constructor<CreateFileAction> action = CreateFileAction.class
                .getConstructor(CreateFile.class);
        CreateFile file = new CreateFile();
        System.out.println(action.newInstance(file));
        // System.out.println(action);
    }
}