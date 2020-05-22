//do the text replacement within the sql
private static int replaceASTNodeWith(StringBuilder sql, int delta, ASTNodeAccess node, String expr) {
        sql.replace(
                node.getASTNode().jjtGetFirstToken().absoluteBegin + delta - 1,
                 node.getASTNode().jjtGetLastToken().absoluteEnd + delta - 1,
                 expr);
        return delta + expr.length() 
                 - (node.getASTNode().jjtGetLastToken().absoluteEnd - node.getASTNode().jjtGetFirstToken().absoluteBegin);
}