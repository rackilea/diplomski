try
    {
         Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
         System.setProperty("DUCANACCESS_HOME","C:/Users/mindurka/Downloads
         /Selenium3.4/UCanAccess-4.0.2-bin/UCanAccess-4.0.2-bin");

         String connURL = "jdbc:ucanaccess://"+TestCaseSheetPath;
         Connection objAccessCon = DriverManager.getConnection(connURL);

         String strEnvQuery = "Select * from Env where Use = 'Yes'";

         PreparedStatement pst = objAccessCon.prepareStatement(strEnvQuery);

         ResultSet objEnvRS = pst.executeQuery();


         //ResultSet objEnvRS = pst.getResultSet();

         Statement objRS = objAccessCon.createStatement();
         while(objEnvRS.next() == true) //shows true for objEnvRS.next() == true
         {strURL = objEnvRS.getString("URL");
         }