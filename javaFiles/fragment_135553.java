File   f = new File("/Users/Raj/Desktop/datafile.xls");  //Create File Object to locate file on system
        Workbook w = Workbook.getWorkbook(f); //Activate the Workbook
        Sheet s = w.getSheet(0);  //Activate Sheet (either by name or id). Id starts with 0
        int rows= s.getRows() ; //Get Row Count
        int columns = s.getColumns();

        //sheet's columns and rows are started with (column = 0, row = 0)
        int firstColumn = 0;
        int secondColumn = 1;
        int secondRow = 1;

        int firstColumnData = Integer.parseInt(s.getCell(firstColumn, secondRow).getContents());
        int secondColumnData = Integer.parseInt(s.getCell(secondColumn, secondRow).getContents());

        int desiredData = firstColumnData + secondColumnData;

        System.out.println("First Column: "+firstColumnData + " Second Column Data: "+secondColumnData + " Sum Data: "+desiredData);