for (Object obj : objects) {
    Class<?> clzz = obj.getClass();
    Method method = clzz.getDeclaredMethod("getKey");
    String val = (String) method.invoke(obj);
    System.out.println("value : " + val); // prints SytemRunning, SystemStopped and tmpIdle
}