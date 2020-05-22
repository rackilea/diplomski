HSSFWorkbook workbook = new HSSFWorkbook(file);

        //Get first/desired sheet from the workbook
        HSSFSheet sheet = workbook.ge`enter code here`tSheetAt(0);

        //Iterate through each rows one by one
        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext())
        {
            Row row = rowIterator.next();
            //For each row, iterate through all the columns
            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext())
            {

                Cell cell = cellIterator.next();
                //Check the cell type and format accordingly
                switch (cell.getCellType())
                {
                case Cell.CELL_TYPE_NUMERIC:
                        if (DateUtil.isCellDateFormatted(cell)) {
                    System.out.println(cell.getDateCellValue() + "\t\t\t\t");
                } else {
                    System.out.println(cell.getNumericCellValue() + "\t\t\t\t");
                }
                break;
                    case Cell.CELL_TYPE_STRING:
                        System.out.print(cell.getStringCellValue() + "\t\t\t\t");
                        break;
//                       case Cell.CELL_TYPE_BLANK:
//                           System.out.println("0"+ "\t\t");
//                           break;

                }
            }
            System.out.println("");
        }
        file.close();
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }    

    }