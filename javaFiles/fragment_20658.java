public class CheckSQLs {

  public static void main(String[] args) throws JSQLParserException {
    String sqls = "create table foo (\n"
            + "    id int not null auto_increment,\n"
            + "    term_id varchar(128) not null,\n"
            + "    term_name varchar(255) not null,\n"
            + "    parent_id varchar(128) not null,\n"
            + "    parent_name varchar(255),\n"
            + "    top_term_flag varchar(5),\n"
            + "    primary key (id)\n"
            + ");\n"
            + "create index foo_pn on foo( parent_name );\n"
            + "create index foo_ttf on foo ( top_term_flag );";

    for (String sql : sqls.split(";")) {
        Statement parse = CCJSqlParserUtil.parse(sql);
        System.out.println(parse);
        if (parse instanceof CreateTable) {
            CreateTable ct = (CreateTable)parse;
            System.out.println("table=" + ct.getTable().getFullyQualifiedName());
            for (ColumnDefinition colDef : ct.getColumnDefinitions()) {
                System.out.println("column=" + colDef.getColumnName() + " " + colDef.getColDataType() + " " + colDef.getColumnSpecStrings());
            }
        } 
    }
  }
}