try (
         // Step 1: Allocate a database "Connection" object
         Connection conn = DriverManager.getConnection(
               "jdbc:mysql://localhost:8888/ebookshop", "myuser", "password"); // MySQL

         // Step 2: Allocate a "Statement" object in the Connection
         Statement stmt = conn.createStatement();
      ) {
         String strSelect = "BACKUP DATABASE 'databaseOfNames' TO DISK = 'c:\myFile' ";
         ResultSet rset = stmt.execute(strSelect);
      }