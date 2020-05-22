//Shortcut
Expression parseCondExpression = CCJSqlParserUtil.parseCondExpression("new_call.cdctype=goal.cdctype");
System.out.println(parseCondExpression);

//from issue
String sql = "new_call.cdctype=goal.cdctype";
CCJSqlParser parser = new CCJSqlParser(new StringProvider(sql));
try {
    parser.RegularCondition();
} catch (ParseException e) {
    e.printStackTrace();
}