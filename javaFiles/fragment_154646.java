ReportClientDocument clientDoc = new ReportClientDocument();
....
DatabaseController dbController=clientDoc.getDatabaseController();
IConnectionInfo ConnInfo = dbController.getConnectionInfos(null).getConnectionInfo(0);
com.crystaldecisions.sdk.occa.report.lib.PropertyBag boPropertyBag1 = new com.crystaldecisions.sdk.occa.report.lib.PropertyBag();
// Set the properties for the connection
boPropertyBag1.put("JDBC Connection String", connString);
boPropertyBag1.put("Database Class Name", dbClassName);
boPropertyBag1.put("Connection URL", connString);
boPropertyBag1.put("Server", serverHost);
....
// Assign the properties to the connection info
ConnInfo.setAttributes(boPropertyBag1);
// Set the DB Username and Pwd
ConnInfo.setUserName(usrName);
ConnInfo.setPassword(pwd);