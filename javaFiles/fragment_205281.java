import java.util.*;

interface Operator {
  boolean compare(int a, int b);
}

class Launch
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Map<String, Operator> opMap = new HashMap<String, Operator>();
        opMap.put(">", new Operator() {
            @Override public boolean compare(int a, int b) {
                return a > b;
            }
        });
        opMap.put("<", new Operator() {
            @Override public boolean compare(int a, int b) {
                return a < b;
            }
        });
        opMap.put("==", new Operator() {
            @Override public boolean compare(int a, int b) {
                return a == b;
            }
        });
        String op = ">";
        int i = 4, j = 5;
        boolean test = opMap.get(op).compare(i, j);
        System.out.printf("test: %b, i: %d, op: %s, j: %d\n", test, i, op, j);
            //prints: test: false, i: 4, op: >, j: 5
    }
}