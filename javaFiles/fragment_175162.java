String callerName = Thread.currentThread().getStackTrace()[2].getClassName();

try {
    Class<?> caller = Class.forName(callerName);
    // Do something with it ...
} catch (ClassNotFoundException e) {
    e.printStackTrace();
}