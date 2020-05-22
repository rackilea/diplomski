StringBuilder columnNames = new StringBuilder();
   StringBuilder bindVariables = new StringBuilder();

   for (int i = 1; i <= meta.getColumnCount(); i++)
       if (i > 1) {
           columnNames.append(", ");
           bindVariables.append(", ");
       }

       columnNames.append(meta.getColumnName(i));
       bindVariables.append('?');
   }

   String sql = "INSERT INTO " + table + " ("
              + columnNames
              + ") VALUES ("
              + bindVariables
              + ")"