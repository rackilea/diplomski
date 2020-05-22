public class MultiFromItems {
    public static void main(String args[]) throws JSQLParserException {
        String sql = "select t1.a, t2.b from t1, t2 where t1.id = t2.id";
        Statement parse = CCJSqlParserUtil.parse(sql);
        Select select = (Select)parse;
        PlainSelect ps = (PlainSelect)select.getSelectBody();
        System.out.println(ps);
        System.out.println(ps.getFromItem());
        System.out.println(ps.getJoins().get(0));
    }
}