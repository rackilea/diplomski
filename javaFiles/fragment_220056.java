/**
 * @author Rustam
 */
public class Test {


    public static void main(String[] args) throws FileNotFoundException,
            UnsupportedEncodingException {

        Eval eval = new Eval();
        eval.evaluate("System.out.println(\"Hello!!! I'm an auto-generated .java file!\")");
        try {
            runProcess("javac Auto.java");
            runProcess("java Auto");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void runProcess(String command) throws Exception {
        Process pro = Runtime.getRuntime().exec(command);
        printLines(command + " stdout:", pro.getInputStream());
        printLines(command + " stderr:", pro.getErrorStream());
        pro.waitFor();
        System.out.println(command + " exitValue() " + pro.exitValue());
    }

    private static void printLines(String name, InputStream ins) throws Exception {
        String line = null;
        BufferedReader in = new BufferedReader(
                new InputStreamReader(ins));
        while ((line = in.readLine()) != null) {
            System.out.println(name + " " + line);
        }
    }
}

class Eval
{
    public Eval()
    {

    }

    public void evaluate(String toEval) throws FileNotFoundException, UnsupportedEncodingException
    {
        PrintWriter writer = new PrintWriter("Auto.java", "UTF-8");
        writer.println("public class Auto");
        writer.println("{");
        writer.println("    public static void main(String[] args)");
        writer.println("    {");
        writer.println("        " + toEval + ";");
        writer.println("    }");
        writer.println("}");
        writer.close();
        System.out.println("Auto.java created..");
    }
}