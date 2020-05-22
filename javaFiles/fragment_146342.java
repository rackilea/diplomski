interface Folder {
    // we could use the name "fold" for all of these, overloading on the
    //   argument type, and the dispatch code in each concrete Expression
    //   class would still do the right thing (selecting an overload using
    //   the type of "this") --- but this is a little easier to follow
    Expression foldBinaryOperation(BinaryOperation expr);
    Expression foldUnaryOperation(UnaryOperation expr);
    Expression foldNumber(Number expr);
    Expression foldVariable(Variable expr);
}

abstract class Expression {
    abstract Expression fold(Folder f);

    // logic to build a readable representation for testing
    abstract String repr();
}

enum BinaryOperator {
    PLUS,
    MINUS,
    MUL,
    DIV,
}

enum UnaryOperator {
    NEGATE,
}

class BinaryOperation extends Expression {
    public BinaryOperation(BinaryOperator operator,
            Expression left, Expression right)
    {
        this.operator = operator;
        this.left = left;
        this.right = right;
    }

    public BinaryOperator operator;
    public Expression left;
    public Expression right;

    public Expression fold(Folder f) {
        return f.foldBinaryOperation(this);
    }

    public String repr() {
        // parens for clarity
        String result = "(" + left.repr();
        switch (operator) {
            case PLUS:
                result += " + ";
                break;
            case MINUS:
                result += " - ";
                break;
            case MUL:
                result += " * ";
                break;
            case DIV:
                result += " / ";
                break;
        }
        result += right.repr() + ")";
        return result;
    }
}

class UnaryOperation extends Expression {
    public UnaryOperation(UnaryOperator operator, Expression operand)
    {
        this.operator = operator;
        this.operand = operand;
    }

    public UnaryOperator operator;
    public Expression operand;

    public Expression fold(Folder f) {
        return f.foldUnaryOperation(this);
    }

    public String repr() {
        String result = "";
        switch (operator) {
            case NEGATE:
                result = "-";
                break;
        }
        result += operand.repr();
        return result;
    }
}

class Number extends Expression {
    public Number(double value)
    {
        this.value = value;
    }

    public double value;

    public Expression fold(Folder f) {
        return f.foldNumber(this);
    }

    public String repr() {
        return Double.toString(value);
    }
}

class Variable extends Expression {
    public Variable(String name)
    {
        this.name = name;
    }

    public String name;

    public Expression fold(Folder f) {
        return f.foldVariable(this);
    }

    public String repr() {
        return name;
    }
}

// a base class providing "standard" traversal logic (we could have
//   made Folder abstract and put these there
class DefaultFolder implements Folder {
    public Expression foldBinaryOperation(BinaryOperation expr) {
        // recurse into both sides of the binary operation
        return new BinaryOperation(
                expr.operator, expr.left.fold(this), expr.right.fold(this));
    }

    public Expression foldUnaryOperation(UnaryOperation expr) {
        // recurse into operand
        return new UnaryOperation(expr.operator, expr.operand.fold(this));
    }

    public Expression foldNumber(Number expr) {
        // numbers are "terminal": no more recursive structure to walk
        return expr;
    }

    public Expression foldVariable(Variable expr) {
        // another non-recursive expression
        return expr;
    }
}

class Simplifier extends DefaultFolder {
    public Expression foldBinaryOperation(BinaryOperation expr) {
        // we want to do a depth-first traversal, ensuring that all
        //   sub-expressions are simplified before their parents...
        // ... so begin by invoking the superclass "default"
        //   traversal logic.
        BinaryOperation folded_expr =
            // this cast is safe because we know the default fold
            //   logic never changes the type of the top-level expression
            (BinaryOperation)super.foldBinaryOperation(expr);

        // now apply our "shallow" simplification logic on the result
        switch (folded_expr.operator) {
            case PLUS:
                // x + 0 => x
                if (folded_expr.right instanceof Number
                        && ((Number)(folded_expr.right)).value == 0)
                    return folded_expr.left;

                // 0 + x => x
                if (folded_expr.left instanceof Number
                        && ((Number)(folded_expr.left)).value == 0)
                    return folded_expr.right;
                break;

            case MINUS:
                // x - 0 => x
                if (folded_expr.right instanceof Number
                        && ((Number)(folded_expr.right)).value == 0)
                    return folded_expr.left;

                // 0 - x => -x
                if (folded_expr.left instanceof Number
                        && ((Number)(folded_expr.left)).value == 0) {
                    // a weird case: we need to construct a UnaryOperator
                    //   representing -right, then simplify it
                    UnaryOperation minus_right = new UnaryOperation(
                            UnaryOperator.NEGATE, folded_expr.right);
                    return foldUnaryOperation(minus_right);
                }
                break;

            case MUL:
                // 1 * x => x
                if (folded_expr.left instanceof Number
                        && ((Number)(folded_expr.left)).value == 1)
                    return folded_expr.right;

            case DIV:
                // x * 1 => x
                // x / 1 => x
                if (folded_expr.right instanceof Number
                        && ((Number)(folded_expr.right)).value == 1)
                    return folded_expr.left;
                break;
        }

        // no rules applied
        return folded_expr;
    }

    public Expression foldUnaryOperation(UnaryOperation expr) {
        // as before, go depth-first:
        UnaryOperation folded_expr =
            // see note in foldBinaryOperation about safety here
            (UnaryOperation)super.foldUnaryOperation(expr);

        switch (folded_expr.operator) {
            case NEGATE:
                // --x => x
                if (folded_expr.operand instanceof UnaryOperation
                        && ((UnaryOperation)folded_expr).operator ==
                           UnaryOperator.NEGATE)
                    return ((UnaryOperation)folded_expr.operand).operand;

                // -(number) => -number
                if (folded_expr.operand instanceof Number)
                    return new Number(-((Number)(folded_expr.operand)).value);
                break;
        }

        // no rules applied
        return folded_expr;
    }

    // we don't need to implement the other two; the inherited defaults are fine
}

public class Simplify {
    public static void main(String[] args) {
        Simplifier simplifier = new Simplifier();

        Expression[] exprs = new Expression[] {
            new BinaryOperation(
                    BinaryOperator.PLUS,
                    new Number(0.0),
                    new Variable("x")
            ),

            new BinaryOperation(
                BinaryOperator.PLUS,
                new Number(17.3),
                new UnaryOperation(
                    UnaryOperator.NEGATE,
                    new UnaryOperation(
                        UnaryOperator.NEGATE,
                        new BinaryOperation(
                            BinaryOperator.DIV,
                            new Number(0.0),
                            new Number(1.0)
                        )
                    )
                )
            ),
        };

        for (Expression expr: exprs) {
            System.out.println("Unsimplified: " + expr.repr());

            Expression simplified = expr.fold(simplifier);
            System.out.println("Simplified: " + simplified.repr());
        }
    }
}