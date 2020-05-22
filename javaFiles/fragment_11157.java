public class YourClass {
...

    public String getOutputStringFromJar() {
        String s = ""; // or = null;

        try {
            Process p = Runtime.getRuntime().exec("java -jar full/path/to/your/Jar.jar full/path/to/fibonacci.asm");// just like you would do it on your terminal
            p.waitFor();

            InputStream is = p.getInputStream();

            byte b[] = new byte[is.available()];
            is.read(b, 0, b.length); // probably try b.length-1 or -2 to remove "new-line(s)"

            s = new String(b);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return s;
    }
...
}