class MyExtraClass {
    public static void doStuff() {
        DeleteClass c = new DeleteClass();
        c.test(c);
    }
}

public boolean checkForClass(String className) {
    try  {
        Class.forName(className);
        return true;
    }  catch (ClassNotFoundException e) { return false; }
}

// somewhere in your code
    if (checkForClass("package.DeletedClass")) {
        MyExtraClass.doStuff();
    }