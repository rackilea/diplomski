package myjythonproject;
import org.python.util.PythonInterpreter;

public class MyJythonProject {

    public static void main(String[] args) {
        try
        {
            PythonInterpreter.initialize(System.getProperties(), System.getProperties(), new String[0]);
            PythonInterpreter interp = new PythonInterpreter();
            interp.execfile("/home/vicent/foo.py");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}