/**
 * Created by SEA-HAWK on 23/8/15.
 */
public abstract class Expr {
    public static Map<String,Object> op;
    static{
        op=new HashMap<>();
        op.put("+", new Expr() {
            @Override
            public int evaluate(int a, int b) {
                return a + b;
            }
        });
        op.put("-", new Expr() {
            @Override
            public int evaluate(int a, int b) {
                return a - b;
            }
        });
        op.put("*", new Expr() {
            @Override
            public int evaluate(int a, int b) {
                return a * b;
            }
        });

        op.put("/", new Expr() {
            @Override
            public int evaluate(int a, int b) {
                return a / b; // decimal point loss
            }
        });
    }
    abstract public int evaluate(int a, int b);
    public static int exprEval(String expr){
        String a[]=expr.split(",");
        a[2]=a[2].replaceAll("\"","");
        return ((Expr)op.get(a[2])).evaluate(Integer.parseInt(a[0]),Integer.parseInt(a[1]));
    }
}