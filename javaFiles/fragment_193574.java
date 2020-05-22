// Make sure to use version 4.2, as SQLServerBulkCSVFileRecord is not included in version 4.1
import com.microsoft.sqlserver.jdbc.*;

long startTime = System.currentTimeMillis();
SQLServerBulkCSVFileRecord fileRecord = null;  

fileRecord = new SQLServerBulkCSVFileRecord("C:\\temp\\test.txt", true);   
fileRecord.addColumnMetadata(1, null, java.sql.Types.NVARCHAR, 50, 0);  
fileRecord.addColumnMetadata(2, null, java.sql.Types.INTEGER, 0, 0);  
Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
Connection destinationConnection = DriverManager.getConnection("jdbc:sqlserver://Server\\\\Instance:1433", "user", "pass");
SQLServerBulkCopyOptions copyOptions = new SQLServerBulkCopyOptions();  

// Depending on the size of the data being uploaded, and the amount of RAM, an optimum can be found here. Play around with this to improve performance.
copyOptions.setBatchSize(300000); 

// This is crucial to get good performance
copyOptions.setTableLock(true);  

SQLServerBulkCopy bulkCopy =  new SQLServerBulkCopy(destinationConnection);
bulkCopy.setBulkCopyOptions(copyOptions);  
bulkCopy.setDestinationTableName("TestTable");
bulkCopy.writeToServer(fileRecord);

long endTime   = System.currentTimeMillis();
long totalTime = endTime - startTime;
System.out.println(totalTime + "ms");