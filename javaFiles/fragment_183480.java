public static IBorrowable getBorrowable1()  //returns a class which implements IBorrowable
{
     try {
        ClassLoader myClassLoader = ClassLoader.getSystemClassLoader();
        Class<IBorrowable> clazz = (IBorrowable) myClassLoader.loadClass("entityclasses.Books");
        return clazz.newInstance();
    } catch (Exception e) {
        System.out.println("error");
    }
    return null;
}