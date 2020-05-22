ProxyFactory.nameGenerator = new JavassitBackwardCompatibleNamingGenerator();

public class JavassitBackwardCompatibleNamingGenerator implements UniqueName{
    private static int counter = 0;
    @Override
    public String get(String classname) {
        return classname + "_$$_javassist_" + counter++;
    }
}