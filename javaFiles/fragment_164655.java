public class compiler {

    public static void main(String[] args) {
        final String dosCommand = "cmd /c java -cp ";
        final String classname = "code";
        final String location = "D:\\";
        try {
            final Process process = Runtime.getRuntime().exec(dosCommand + location + " " + classname);
            final InputStream in = process.getInputStream();
            final InputStream in2 = process.getErrorStream();
            int ch, ch2;
            while ((ch = in.read()) != -1) {
                System.out.print((char) ch);
            }
            while ((ch2 = in2.read()) != -1) {
                System.out.print((char) ch2); // read error here
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}