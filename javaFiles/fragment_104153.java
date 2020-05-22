public static void main(String[] args) throws JSQLParserException {
    String sql = "SELECT a\n"
            + "FROM table\n"
            + "WHERE a = 1 AND\n"
            + "      b = 2 AND\n"
            + "      c = 3";

    SimpleNode node = (SimpleNode) CCJSqlParserUtil.parseAST(sql);

    node.jjtAccept(new CCJSqlParserDefaultVisitor() {
        @Override
        public Object visit(SimpleNode node, Object data) {
            System.out.println(node.toString() + " firstToken=" + node.jjtGetFirstToken().image 
                    + " line=" + node.jjtGetFirstToken().beginLine);
            return super.visit(node, data);
        }
    }, null);
}