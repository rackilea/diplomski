import java.util.*;

public class test_exp {
    public static void main(String[] args) throws Exception {
        Map<String, Double> vars = new HashMap<String, Double>();
        vars.put("Height", 12.0);
        vars.put("x", 2.0);
        vars.put("y", 2.0);
        System.out.println("Result=" + ExpParser.eval("Height * @cos(x + y)", vars));
    }
}