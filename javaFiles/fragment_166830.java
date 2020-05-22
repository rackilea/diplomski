writer.writeAll(new MyResultSet(rs), true);

//Wrapper class

public class MyResultSet implements Resultset{

 public MyResultSet(Resultset source, Map<String, NumberFormat > formatters){
//setting constructor properties and you can read here SQL resultset Metadata to complete    formatters
}

 //.... you will implement all sql.Resultset methods

  //example to implements

 public String getString(String columnName){
    return formatters.get(columnName).format(source.getInt(columnName));
  }

 public ResultSetMetaData getMetaData(){
   return new MyResultSetMetaData(source);
 }

} 

}
//
   public MyResultSetMetaData implements ResultSetMetaData{
 //will implement all ResultSetMetaData methods,

   //replace Numeric to String the column Type, then the value has retrieved by getString(column)
       public int getColumnType(int columnIndex){
  return Types.VARCHAR;