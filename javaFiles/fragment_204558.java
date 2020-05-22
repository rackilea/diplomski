import java.util.HashMap;
import java.util.Map;

import org.mvel2.MVEL;

public class Test {
    public static void main(String[] args) {
        Map<String, Object> context = new HashMap<String, Object>();

        String col1 = "C";
        String col2 = "D";

        context.put("col1", col1);
        context.put("col2", col2);

        String expression = "col1 == 'C' && col2 == 'D'";
        Boolean result = (Boolean) MVEL.eval(expression,context);
        System.out.println(result);//true

        expression = "col1 == 'E' && col2 == 'D'";
        result = (Boolean) MVEL.eval(expression,context);
        System.out.println(result);//false
    }
}