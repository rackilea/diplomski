System.out.println(Runtime.getRuntime().freeMemory() / 1000000.0 + "MB free");

try {

    // the whole program

} catch(Throwable t) {
    System.out.println(t.getClass().getName() + " " + t.getMessage());
    System.out.println();
    for(StackTraceElement elem : t.getStackTrace()) {
        System.out.println(elem);
    }
}