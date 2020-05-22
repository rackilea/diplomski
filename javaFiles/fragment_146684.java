String sqlTxt = "Select * from customer c inner join address a on c.id = a.customer_id where c.id > {var1} AND (c.name LIKE {var2} OR  a.city = {var3})";

//replace macro constructs
String sql = sqlTxt.replace("{", "__").replace("}", "__");

//build replacement data    
Map<String, String> data = new HashMap<>();
data.put("__var1__", "2");
data.put("__var2__", "*ALL");
data.put("__var3__", "'aa'");

//parse sql
Select select = (Select) CCJSqlParserUtil.parse(sql);

StringBuilder b = new StringBuilder(sql);

//rewrite sql to fit your needs
((PlainSelect) select.getSelectBody()).getWhere().accept(new ExpressionVisitorAdapter() {
    int delta = 0;  //to correct the position due to former replacements

    @Override
    protected void visitBinaryExpression(BinaryExpression expr) {
        if (expr instanceof ASTNodeAccess) {
            if (expr.getRightExpression() instanceof Column) {
                Column c = ((Column) expr.getRightExpression());

                if (data.containsKey(c.getColumnName())) {
                    if ("__var2__".equals(c.getColumnName())) {
                        delta = replaceASTNodeWith(b, delta, (ASTNodeAccess) expr, "1=1");
                    } else {
                        delta = replaceASTNodeWith(b, delta, (ASTNodeAccess) expr,  
                                expr.getLeftExpression() + expr.getStringExpression() + data.get(c.getColumnName()));
                    }
                }
            }
        }
        super.visitBinaryExpression(expr);
    }
});

System.out.println("parsed  sql = " + select.toString());
System.out.println("changed sql = " + b.toString());