String sql = "select * from visitors";
ResultSet rs = stmt.executeQuery( sql );
ResultSetMetaData rsmd = rs.getMetaData();
int columnCount = rsmd.getColumnCount();
String tableName = null;
StringBuilder sb = new StringBuilder( 1024 );
if ( columnCount > 0 ) { 
    sb.append( "Create table " ).append( rsmd.getTableName( 1 ) ).append( " ( " );
}
for ( int i = 1; i <= columnCount; i ++ ) {
    if ( i > 1 ) sb.append( ", " );
    String columnName = rsmd.getColumnLabel( i );
    String columnType = rsmd.getColumnTypeName( i );

    sb.append( columnName ).append( " " ).append( columnType );

    int precision = rsmd.getPrecision( i );
    if ( precision != 0 ) {
        sb.append( "( " ).append( precision ).append( " )" );
    }
} // for columns
sb.append( " ) " );

System.out.println( sb.toString() );