List cellDataList = new ArrayList();
XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

                        XSSFSheet sheet = workbook.getSheetAt(0);

                        Iterator rows = sheet.rowIterator();

                        int number=sheet.getLastRowNum();


                        int lineNumber = 0;

                        while (rows.hasNext())

                        {
                            XSSFRow row = ((XSSFRow) rows.next());
                            lineNumber++;
                            if(lineNumber==1){continue;}




                            Iterator cells = row.cellIterator();
                            List cellTempList = new ArrayList();    
                            int current = 0, next =1;
                            while(cells.hasNext())

                            {

                                XSSFCell cell = (XSSFCell) cells.next();


                                current = cell.getColumnIndex();


                                if(current<next){

                                }
                                else{

                                    int loop = current-next;

                                    for(int k=0;k<loop+1;k++){

                                        cellTempList.add(null);
                                        next = next + 1;
                                    }
                                }
                                switch (cell.getCellType()) {
                                            case Cell.CELL_TYPE_STRING:
                                                System.out.println(cell.getRichStringCellValue().getString());
                                                cellTempList.add(cell.getRichStringCellValue().getString());
                                                break;
                                            case Cell.CELL_TYPE_NUMERIC:                                                    
                                                    System.out.println(cell.getNumericCellValue());
                                                    cellTempList.add(String.valueOf(cell.getNumericCellValue()));                                                   
                                                break;
                                            case Cell.CELL_TYPE_BOOLEAN:
                                                System.out.println(cell.getBooleanCellValue());
                                                break;
                                            case Cell.CELL_TYPE_FORMULA:
                                                System.out.println(cell.getCellFormula());
                                                cellTempList.add(cell.getCellFormula());
                                                break;                                              

                                            default:
                                                System.out.println("Inside default");
                                }
                                next = next + 1;

                            }
                            cellDataList.add(cellTempList); 
                         }