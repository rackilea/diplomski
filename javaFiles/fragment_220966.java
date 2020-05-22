public static void findJarForClass(Class clazz) {
    CodeSource src = clazz.getProtectionDomain().getCodeSource();
    if (src != null) {
        java.net.URL jar = src.getLocation();
        System.out.printf("%s ----> %s%n", clazz, jar);
    }
}