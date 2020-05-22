import rcaller.RCaller;
import rcaller.RCode;

public class RCallerDemo {
    public static void main(String[] args) {
        try {
            RCaller caller = new RCaller();
            caller.setRscriptExecutable("/usr/bin/Rscript");
            caller.cleanRCode();
            RCode code = new RCode();
            final String st1 = "k<-1";
            final String st2 = "b<-print(k)";
            code.addRCode(st1);
            code.addRCode(st2);
            caller.setRCode(code);    //Initializing k to 1
            caller.runAndReturnResult("b"); //This should output the value of b
            int b = caller.getParser().getAsIntArray("b")[0];
            System.out.println(b);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}