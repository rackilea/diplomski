class VarScopes {
    public static void forEachLoop(Collection<?> c) {
        for(Object o: c) {
            System.out.println(o);
        }
    }
    public static void iteratorLoop(Collection<?> c) {
        for(Iterator<?> it = c.iterator(); it.hasNext();) {
            Object o = it.next();
            System.out.println(o);
        }
    }
    public static void iteratorLoopExtendedScope(Collection<?> c) {
        Iterator<?> it;
        Object o;
        for(it = c.iterator(); it.hasNext();) {
            o = it.next();
            System.out.println(o);
        }
    }
    public static void main(String[] args) throws IOException, InterruptedException {
        decompile();
    }
    private static void decompile() throws InterruptedException, IOException {
        new ProcessBuilder(
                Paths.get(System.getProperty("java.home"), "bin", "javap").toString(),
                "-cp", System.getProperty("java.class.path"),
                "-c", MethodHandles.lookup().lookupClass().getName())
                .inheritIO()
                .start()
                .waitFor();
    }
    private VarScopes() {}
}