import org.rosuda.REngine.JRI.*;
import org.rosuda.REngine.*;

public class RCode2 {
    public static JRIEngine re;
    private static  org.rosuda.REngine.REXP rexp;

    public RCode2()
    {
        try {
            re = new JRIEngine(new String [] {"--vanilla"});
        } catch (REngineException e) {
            e.printStackTrace();
        }
        System.out.println("Rengine created, waiting for R");               
    }
    public static void main(String[] args) {
        RCode2 rCode2= new RCode2();
        rCode2.testSqldf(); 
        re.close();
    }
    public void testSqldf(){
        try {
            rexp = re.parseAndEval("library(sqldf)");
            System.out.println(rexp);
            rexp = re.parseAndEval("dframe<-sqldf(\"select * from Orange\")");
            System.out.println(rexp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}