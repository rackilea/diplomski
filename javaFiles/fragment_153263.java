String sql = "SELECT * FROM  ( ( SELECT TBL.ID AS rRowId, TBL.NAME AS name, TBL.DESCRIPTION as description, TBL.TYPE AS type, TBL1.SHORT_NAME AS shortName  FROM ROLE_TBL TBL WHERE ( TBL.TYPE = 'CORE' OR  TBL1.SHORT_NAME = 'TNG' AND  TBL.IS_DELETED <> 1  ) ) MINUS ( SELECT TBL.ID AS rRowId, TBL.NAME AS name, TBL.DESCRIPTION as description, TBL.TYPE AS type, TBL3.SHORT_NAME AS shortName,TBL3.NAME AS tenantName FROM ROLE_TBL TBL INNER JOIN TYPE_ROLE_TBL TBL1 ON TBL.ID=TBL1.ROLE_FK LEFT OUTER JOIN TNT_TBL TBL3 ON TBL3.ID = TBL.TENANT_FK LEFT OUTER JOIN USER_TBL TBL4 ON TBL4.ID = TBL1.USER_FK WHERE ( TBL4.ID =771100 AND  TBL.IS_DELETED <> 1  ) ) ) ORDER BY name ASC";

    System.out.println("using TableNamesFinder to get column names");
    Statement statement = CCJSqlParserUtil.parse(sql);
    Select selectStatement = (Select) statement;
    TablesNamesFinder tablesNamesFinder = new TablesNamesFinder() {
        @Override
        public void visit(Column tableColumn) {
            System.out.println(tableColumn);
        }
    };
    tablesNamesFinder.getTableList(selectStatement);

    System.out.println("-------------------------------------------");
    System.out.println("using ast nodes to get column names");
    SimpleNode node = (SimpleNode) CCJSqlParserUtil.parseAST(sql);

    node.jjtAccept(new CCJSqlParserDefaultVisitor() {
        @Override
        public Object visit(SimpleNode node, Object data) {
            if (node.getId() == CCJSqlParserTreeConstants.JJTCOLUMN) {
                System.out.println(node.jjtGetValue());
                return super.visit(node, data);
            } else {
                return super.visit(node, data);
            }
        }
    }, null);