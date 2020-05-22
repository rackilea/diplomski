import com.foundationdb.sql.parser.*;
import com.foundationdb.sql.StandardException;

public class TableFinder {
    public static void main(String[] args) throws Exception {
        SQLParser parser = new SQLParser();
        for(String sql : args) {
            StatementNode node = parser.parseStatement(sql);
            node.accept(new FromTablePrinter());
        }
    }

    public static class FromTablePrinter implements Visitor {
        public Visitable visit(Visitable node) throws StandardException {
            if(node instanceof FromTable) {
                FromTable ft = (FromTable)node;
                TableName name = ft.getOrigTableName();
                String alias = ft.getCorrelationName();
                if(name != null) {
                    System.out.print(name);
                    if(alias != null) {
                        System.out.print(" AS " + alias);
                    }
                    System.out.println();
                } else if (alias != null) {
                    String type = node.getClass().getSimpleName();
                    System.out.println(type + " AS " + alias);
                }
            }
            return node;
        };

        public boolean visitChildrenFirst(Visitable node) {
            return false;
        }

        public boolean stopTraversal() {
            return false;
        }

        public boolean skipChildren(Visitable node) {
            return false;
        }
    }
}