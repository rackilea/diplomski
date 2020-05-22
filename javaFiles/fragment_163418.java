public static String getColumnName (String input) {
    if (StringUtils.isEmpty(input)) return input;
    String[] tokens = input.split("[(),{}]");
    for (String token: tokens) {
      if (token.contains(".")) return token;
    }
    return input;
}
public static void main(String args[]) throws Exception {
    //The two tokens will be "max", "TableName1.ColumnName1".
    String test1 = "max(TableName1.ColumnName1)";

    //The three tokens will be "concat", "Q" and "TableName2.ColumnName2".
    String test2 = "concat('Q',TableName2.ColumnName2)}";

    //The six tokens will be "left", "convert", "varchar", 
    //"90", "", "1" and "TableName3.ColumnName3".
    String test3 = "left(convert(varchar(90),TableName3.ColumnName3),1)})";

    System.out.println(getColumnName(test1));
    System.out.println(getColumnName(test2));
    System.out.println(getColumnName(test3));
}