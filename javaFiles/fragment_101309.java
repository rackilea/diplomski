ResultSet results = getSession().execute("Select * from test.table");    
int numcols = results.getColumnDefinitions().size();
for ( Row row : results ) {
   for (int colIndex = 0; colIndex < numcols; colIndex++) {
         System.out.println("Type : "+row.getColumnDefinitions().getType(colIndex));
         Class c = row.getColumnDefinitions().getType(colIndex).asJavaClass();
         if(c == Integer.class) {
              System.out.println("Data :" + row.getInt(colIndex));
         }
         //similar for other type
   }
}