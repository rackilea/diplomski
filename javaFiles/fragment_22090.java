class PrintIndentedVisitor implements Visitor<String> {

    private final int indent;

    PrintIndentedVisitor(int indent) {
        this.indent = indent;
    }

    Visitor<String> visitTree(Tree<String> tree) {
        return new IndentVisitor(indent + 2);
    }

    void visitData(Tree<String> parent, String data) {
        for (int i = 0; i < indent; i++) { // TODO: naive implementation
            System.out.print(" ");
        }

        System.out.println(data);
    }
}