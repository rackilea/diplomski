try {
    Class bClass = Class.forName("B");
    System.out.println("exists");
    if (bClass.getProtectionDomain().getCodeSource().getLocation().getPath().contains("MyApp.jar")) {
        System.out.println("class loaded from MyApp.jar");
    } else {
        System.out.println("class not loaded from MyApp.jar");
    }
} catch (Exception ignored) {
    System.out.println("does not exist");
}