public class DataSet {
     private List<Column> columns = new ArrayList<Column>();
     private List<Row> rows = new ArrayList<Row>();

     public void parse( File file ) {
         // routines to read CSV data into this class
     }
 }

 public class Row {
     private Object[] data;

     public void parse( String row, List<Column> columns ) {
         String[] row = data.split(",");
         data = new Object[row.length];

         int i = 0;
         for( Column column : columns ) {
             data[i] = column.convert(row[i]);
             i++;
         }
     }
 }

 public class Column {
     private String name;
     private int index;
     private DataType type;

     public Object convert( String data ) {
         if( type == DataType.NUMERIC ) {
            return Double.parseDouble( data );
         } else {
            return data;
         }
     }
 }

 public enum DataType {
     CATEGORICAL, NUMERIC
 }