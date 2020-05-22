System.out.println("Java version: " + System.getProperty("java.version"));
System.out.println("Java vendor: " + System.getProperty("java.vendor"));
try {
    Class.forName("java.util.zip.ZipConstants64");
    System.out.println("Your Java supports Zip64 :)");
} catch (ClassNotFoundException e) {
    System.out.println("Your Java doesn't support Zip64 :(");
}