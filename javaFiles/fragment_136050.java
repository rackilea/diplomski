public class <T extends Number> ExpressionTree<T> {
    private ExpressionTree<T> left, right;
    private T value;
    private int operator;

    // constructors, getters, setters, etc. elided

    public T evaluateExpression() {
        // Here I am assuming a <T> value field that is set if the node
        // is a literal value rather than an expression subtree with left and right children.
        if (this.value != null)
            return this.value;
        // Evaluate the subtree
        switch (this.operator) {
        case '+':
            return left.evaluateExpression()+right.evaluateExpression();
        // etc for the other operators
        }
    }