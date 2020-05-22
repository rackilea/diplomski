@Test
public void test() {
    Class[] cls = {A.class,B.class};
    // Parallel among classes
    JUnitCore.runClasses(ParallelComputer.classes(), cls);
}