import java.io.*;
import java.lang.reflect.Proxy;

public class SmarterObjectInputStream extends ObjectInputStream {

    public SmarterObjectInputStream(InputStream in) throws IOException {
        super(in);
    }

    protected Class resolveClass(ObjectStreamClass classDesc) throws IOException, ClassNotFoundException {
        try {
            return Class.forName(classDesc.getName(), false, getClassloader());
        } catch (ClassNotFoundException e) {
            String n = classDesc.getName();
            if (n.equals("boolean")) return boolean.class;
            if (n.equals("byte")) return byte.class;
            if (n.equals("char")) return char.class;
            if (n.equals("short")) return short.class;
            if (n.equals("int")) return int.class;
            if (n.equals("long")) return long.class;
            if (n.equals("float")) return float.class;
            if (n.equals("double")) return double.class;

            throw e;
        }
    }

    protected Class resolveProxyClass(String[] interfaces) throws IOException, ClassNotFoundException {
        Class[] cinterfaces = new Class[interfaces.length];
        for (int i = 0; i < interfaces.length; i++)
            cinterfaces[i] = getClassloader().loadClass(interfaces[i]);

        try {
            return Proxy.getProxyClass(getClassloader(), cinterfaces);
        } catch (IllegalArgumentException e) {
            throw new ClassNotFoundException(null, e);
        }
    }

    private ClassLoader getClassloader() {
        return Thread.currentThread().getContextClassLoader();
    }
}