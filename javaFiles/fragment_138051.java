public static void main (String[] args) 
{
    String stat = "INSERT INTO DEPARTMENT(DNO, NAME, TEST_ID) VALUES (2, 'ADM', 1)";
    String tableName = stat.substring(stat.indexOf("INSERT INTO ") + 12,stat.indexOf("("));
    String columnNames = stat.substring(stat.indexOf("(") + 1,stat.indexOf(")"));
    String columnValues = stat.substring(stat.indexOf("VALUES (") + 8,stat.lastIndexOf(")"));

    /* Prepare New Values Object */
    Object[] newValues = new Object[3];
    newValues[0] = new Integer(1);
    newValues[1] = new String("foo");
    newValues[2] = new Integer(8);

    /* Extract Column Names & Appen New Values */
    StringBuilder sb = new StringBuilder();
    sb.append("UPDATE " + tableName + " SET ");
    String[] splits = columnNames.split(", ");
    for(int i = 0; i < splits.length; i++) {
        sb.append(newValues[i] instanceof String ? splits[i] + " = '" + newValues[i] + "', " : splits[i] + " = " + newValues[i] + ", ");
    }
    String newString = sb.substring(0, sb.length() - 2);

    /* Extract Old Values & Prepare Where Caluse */
    sb = new StringBuilder();
    sb.append(" WHERE ");
    String[] splitz = columnValues.split(", ");
    for(int i = 0; i < splits.length; i++) {
        sb.append(splits[i] + " = " + splitz[i] + " AND ");
    }
    String where = sb.substring(0, sb.length() - 5);

    /* Print Result */
    System.out.println(newString + where);
}