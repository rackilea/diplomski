public class MyClassLoader extends ClassLoader
{
    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        try {
            byte b[] = Files.readAllBytes(Paths.get("target/classes/"+name+".class"));
            ByteBuffer bb = ByteBuffer.wrap(b); 
            return super.defineClass(name, bb,null);
        } catch (IOException ex) {
            return super.loadClass(name);
        }
    }


    public String invoke(final String className, final String methodName, final String someString)
    {
        try {
            final ClassLoader classLoader = this;