static Class class$(java.lang.String className) {
    try {
       return Class.forName(className);
    } catch (ClassNotFoundException e) {
       throw new NoClassDefFoundError();
    }
}