InputStream inp = new FileInputStream("test.xlsx");
        Workbook wb = WorkbookFactory.create(inp);
        Sheet sheet = wb.getSheetAt(0);
        Name name;
        name = wb.getName("NameOFStudents");
        name.setRefersToFormula("Sheet1!$A$1:$A$20");
        FileOutputStream fileout = new FileOutputStream("test2..xlsx");
        wb.write(fileout);
        fileout.close();