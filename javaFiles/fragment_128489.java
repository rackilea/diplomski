public class MyDoclet extends Doclet {

    public static void main(String[] args) {
        com.sun.tools.javadoc.Main.execute("-doclet " + MyDoclet.class.getName());
    }
}