import org.antlr.runtime.*;
import java.util.*;

public class ANTLRDemo {
    public static void main(String[] args) throws Exception {
        Map<String, Double> vars = new HashMap<String, Double>();
        vars.put("two", 2.0);
        vars.put("pi", Math.PI);
        System.out.println(ExpParser.eval("two * pi", vars));
    }
}