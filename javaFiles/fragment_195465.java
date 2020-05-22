package test;
import java.io.File;

public class Test {
    public static void main(String[] args) {

        try {
            ClassLoader cl = ClassLoader.getSystemClassLoader();
            File subfolder = new File("subfolder");

            for (File f : subfolder.listFiles()) {
                String s = f.getName();
                System.out.println("Loading " + s);
                Class cls = cl.loadClass(s.substring(0, s.lastIndexOf('.')));

                MyInterface o = (MyInterface) cls.newInstance();
                o.printSomething();
            }
        } catch (ClassNotFoundException e) {
        } catch (InstantiationException e) {
        } catch (IllegalAccessException e) {
        }
    }
}