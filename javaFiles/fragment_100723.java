public class script1302766776488 extends groovy.lang.Script { 
        // ...
        public static void foo() {
            this.println(this.getClass())
            java.lang.ClassLoader parent = this.getClass().getClassLoader()
            this.println(parent)
        }
        // ...