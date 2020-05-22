public class TreeClasses {
    public static abstract class ExpressionTreeNode {
        public abstract double eval();
    }

    public static class Addition extends ExpressionTreeNode {

        ExpressionTreeNode left;
        ExpressionTreeNode right;

        public Addition(ExpressionTreeNode left, ExpressionTreeNode right) {
            this.left = left;
            this.right = right;
        }

        public double eval() {
            double arg1 = left.eval();
            double arg2 = right.eval();

            return arg1+arg2;
        }
    }

    public static class Constant extends ExpressionTreeNode {
        double val;

        public Constant(double val) {
            this.val = val;
        }

        @Override
        public double eval() {
            return val;
        }


    }

    public static void main(String[] args) {
        ExpressionTreeNode tree = new Addition(new Constant(1),new Constant(2));
        System.out.println(tree.eval());
    }
}