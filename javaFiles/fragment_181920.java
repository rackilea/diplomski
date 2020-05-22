package stackoverflow;

import java.io.*;
import org.apache.bcel.*;

public class SampleBcel {

    Runnable runnable = new Runnable() {
        File f = new File("temp.txt");
        @Override
        public void run() {
            try (BufferedReader r = new BufferedReader(new FileReader(f))) {
                String line;
                while ((line = r.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    };

    public static void main(String[] args) throws ClassNotFoundException {
        JavaClass runnableClass = Repository.lookupClass("stackoverflow.SampleBcel$1");
        System.out.println(runnableClass); 
        Method[] runnableMethods = runnableClass.getMethods();
        for (Method method : runnableMethods) {
            System.out.println("** method : " + method);
            LocalVariableTable local = method.getLocalVariableTable();
            System.out.println(local);
        }
    }
}