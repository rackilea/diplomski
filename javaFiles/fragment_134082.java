import java.util.Optional;

public class Div implements Expr {

    Expr expr1;
    Expr expr2;

    public Div(Expr expr1, Expr expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    @Override
    public Optional<Integer> eval() {
        return expr1.eval().flatMap(v1 ->
                expr2.eval().flatMap(v2 ->
                    (v2 == 0) ? Optional.empty() : Optional.of(v1 / v2)
                )
               );
    }

    public static void main(String[] args) {
        Expr iv1 = new Val(6);
        Expr iv2 = new Val(3);
        Expr iv3 = new Val(2);
        Expr iv4 = new Val(0);
        Expr div1 = new Div(iv1, iv2);
        Expr div2 = new Div(div1, iv3);
        Expr div3 = new Div(div2, iv4);

        System.out.println(div2.eval());
        System.out.println(div3.eval());

    }
}