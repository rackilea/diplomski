package com.company;

public class Run {

    public Run() {
    }

    public String runThis(String var1, String var2, String var3) throws Exception {
        MyObject object= new MyObject(var1, var2, var3);
        return object.execute();
    }

    public static String print(String input) {
        return input;
    }
}