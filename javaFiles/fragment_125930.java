class EvalVisitor implements Visitor{

        public Integer visit(IntegerNode node) {
            return node.getValue();
        }

        public Integer visit(PlusTreeExpression tree) {
            return this.visit(tree.getChildA()) + this.visit(tree.getChildB());
        }

        public Integer visit(MultiplyTreeExpression tree) {
            return this.visit(tree.getChildA()) * this.visit(tree.getChildB());
        }
    }