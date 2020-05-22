import java.io.*;
import java.awt.Frame;
import java.util.Enumeration;

import org.rosuda.JRI.Rengine;
import org.rosuda.JRI.REXP;
import org.rosuda.JRI.RVector;
import org.rosuda.JRI.RMainLoopCallbacks;

public class rJavaTest {

    public static void main(String[] args) {

        Rengine re=new Rengine(args, false, new TextConsole());
        REXP x;
        re.eval("print(1:10/3)");
        System.out.println(x=re.eval("iris"));
        RVector v = x.asVector();
        if (v.getNames()!=null) {
            System.out.println("has names:");
            for (Enumeration e = v.getNames().elements() ; e.hasMoreElements() ;) {
                System.out.println(e.nextElement());
            }
        }

        if (true) {
            System.out.println("Now the console is yours ... have fun");
            re.startMainLoop();
        } else {
            re.end();
            System.out.println("end");
        }
    }
}