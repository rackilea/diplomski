private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {
    // the SQL INSERT statement
    String sql="Insert into APP.WSP(QUALIFICATIONTYPE ,QUALIFICATIONGROUP ,MANAGERS ,PROFESSIONALS,"+
            "TECHNICIANSASSOCIATEPROFESSIONALS,CLERICALSUPPORT,SERVICESALES,SKILLEDWORKERS,PLANTMACHINEOPERATORS,"+
            "ELEMENTARYOCCUPATION,LEARNERS,TOTALTRAININGPLANNED)"+
            "values(?,?,?,?,?,?,?,?,?,?,?,?)";

    // use try-with resources!
    // BTW: Class.forName() is no more required for properly installed drivers in Java 7
    try (FileInputStream file = new FileInputStream("new.xls");
         Connection con = DriverManager.getConnection("jdbc:derby:MTD","herbert","elsie1*#");
         PreparedStatement pst = con.prepareStatement(sql)) {

        // create workbook
        org.apache.poi.ss.usermodel.Workbook workbook = WorkbookFactory.create(file);
        org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();

        // skip the first line (headline)
        rowIterator.next(); 

        // use this to retrieve Strings from numeric cells
        DataFormatter df = new DataFormatter();

        while(rowIterator.hasNext())
        {
            Row row = rowIterator.next();

            // get cell values
            QT=df.formatCellValue(row.getCell(0));
            QG=df.formatCellValue(row.getCell(1));
            Mgr=df.formatCellValue(row.getCell(2));
            TAP=df.formatCellValue(row.getCell(3));
            Prof =df.formatCellValue(row.getCell(4));
            CS=df.formatCellValue(row.getCell(5));
            SS=df.formatCellValue(row.getCell(6));
            SW=df.formatCellValue(row.getCell(7));
            PMO=df.formatCellValue(row.getCell(8));
            EO=df.formatCellValue(row.getCell(9));
            Learner=df.formatCellValue(row.getCell(10));
            TTP=df.formatCellValue(row.getCell(11));

            // print to console
            System.out.println(QT+QG+Mgr+TAP+Prof+CS+SS+SW+PMO+EO+Learner+TTP);
            System.out.println("");

            // write to database
            pst.setString(1, QT);
            pst.setString(2, QG);
            pst.setString(3, Mgr);
            pst.setString(4, TAP);
            pst.setString(5, Prof);
            pst.setString(6, CS);
            pst.setString(7, SS);
            pst.setString(8, SW);
            pst.setString(9, PMO);
            pst.setString(10, EO);
            pst.setString(11, Learner);
            pst.setString(12, TTP);
            pst.executeUpdate();        
        }

        // what does this do?
        updateTable(); 

        // show success dialog
        JOptionPane.showMessageDialog(null,"Values Inserted Successfully");
    } catch(Exception e){
        // Show error dialog
        JOptionPane.showMessageDialog(null, e);
    }
}