import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.expression.LongValue;
import net.sf.jsqlparser.expression.StringValue;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.util.deparser.ExpressionDeParser;
import net.sf.jsqlparser.util.deparser.SelectDeParser;
import net.sf.jsqlparser.util.deparser.StatementDeParser;

public class TestTest {

    public static void main(String[] args) throws JSQLParserException {
        String sql_1 = "SELECT * FROM mytable1 WHERE field1  = 5;";
        String sql_2 = "UPDATE mytable1 SET field1 ='data' WHERE field1 = 5;";
        String sql_3 = "INSERT INTO mytable1 VALUES('a','b','c' );";

        System.out.println(modify(sql_1));
        System.out.println(modify(sql_2));
        System.out.println(modify(sql_3));
    }
    public static String modify(String sql) throws JSQLParserException{
        StringBuilder buffer = new StringBuilder();
        ExpressionDeParser expressionDeParser = new ExpressionDeParser() {
            @Override
            public void visit(StringValue stringValue) {
                this.getBuffer().append("?");
            }

            @Override
            public void visit(LongValue longValue) {
                this.getBuffer().append("?");
            }
        };
        SelectDeParser selectDeparser = new SelectDeParser(expressionDeParser,buffer );
        expressionDeParser.setSelectVisitor(selectDeparser);
        expressionDeParser.setBuffer(buffer);
        StatementDeParser stmtDeparser = new StatementDeParser(expressionDeParser, selectDeparser, buffer);
        Statement stmt = CCJSqlParserUtil.parse(sql);
        stmt.accept(stmtDeparser);
        return stmtDeparser.getBuffer().toString();
    }
}

// output: 
//SELECT * FROM mytable1 WHERE field1 = ?
//UPDATE mytable1 SET field1 = ? WHERE field1 = ?
//INSERT INTO mytable1 VALUES (?, ?, ?)