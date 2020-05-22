import org.apache.commons.jexl2.*;

public class NelderMead {
    // контсанты
    private static int      M = 3;
    private static double   E = 0.005;
    private static double   A = 1.000;
    private static double   B = 0.500;
    private static double   Y = 2.000;

    // переменные
    private JexlEngine jexl;
    private Expression func;
    private String funcString = "";
    private MapContext[] iterations;

    public NelderMead(){
        this.jexl = new JexlEngine();
    }

    public NelderMead(String funcString){
        this.jexl = new JexlEngine();
        this.setFunc(funcString);
    }


    public void setFunc(String funcString){
        this.funcString = funcString;
        this.func = this.jexl.createExpression(funcString);
    }

    public double funcEval(MapContext args){
    return ((Long) this.func.evaluate(args)).doubleValue();

    }

    public boolean checkCriterian(){
        return true;
    }
}