public class CustomClassLoader extends ClassLoader {
    private Class<?> findClass(String class) {
        try {
            File contentDir = ...; // You have to fill this in with the location of the content dir
            final byte[] data = IOUtils.readData(new File(contentDir, class + ".class");
            return defineClass(class, data, 0, data.length);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}