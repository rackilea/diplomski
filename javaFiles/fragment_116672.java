public class SimpleSqlParser24 {

    public static void main(String args[]) throws JSQLParserException {
        replaceTableName("select id, test from test where name = \"test\"");
        replaceTableName("select * from t2 join t1 on t1.aa = t2.bb where t1.a = \"someCondition\" limit 10");
    }

    private static void replaceTableName(String sql) throws JSQLParserException {
        Select select = (Select) CCJSqlParserUtil.parse(sql);

        StringBuilder buffer = new StringBuilder();
        ExpressionDeParser expressionDeParser = new ExpressionDeParser() {
            @Override
            public void visit(Column tableColumn) {
                if (tableColumn.getTable() != null) {
                    tableColumn.getTable().setName(tableColumn.getTable().getName() + "_mytest");
                }
                super.visit(tableColumn);
            }

        };
        SelectDeParser deparser = new SelectDeParser(expressionDeParser, buffer) {
            @Override
            public void visit(Table tableName) {
                tableName.setName(tableName.getName() + "_mytest");
                super.visit(tableName);
            }
        };
        expressionDeParser.setSelectVisitor(deparser);
        expressionDeParser.setBuffer(buffer);
        select.getSelectBody().accept(deparser);

        System.out.println(buffer.toString());
    }
}