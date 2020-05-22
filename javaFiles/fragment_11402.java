for (int i = 0; i < wb.getNumberOfSheets(); i++) {

            System.out.println("Sheet name: " + wb.getSheetName(i));
            Sheet sh=wb.getSheetAt(i);

            if (wb.getSheetName(i).matches("A|B|C|D"))
            {
                int rowCount = sh.getLastRowNum() - sh.getFirstRowNum();

                for (int j = 0; j < rowCount + 1; j++) {

                    Row row = sh.getRow(j);


                    if(row.getCell(0).getStringCellValue().contains("Location Name")){
                    {
                        if(row.getCell(1).getStringCellValue().equalsIgnoreCase("Hydrabad")){
                            System.out.print("Location name is matches with Hydrabad");
                        }
                        else{
                            System.out.print("Location name isn't matches with Hydrabad");
                        }
                    }

                    if(row.getCell(0).getStringCellValue().contains("Location ID")){
                    {
                        if(row.getCell(1).getStringCellValue().equalsIgnoreCase("1")){
                            System.out.print("Location id matches");
                        }
                        else{
                            System.out.print("Location id mismatches");
                        }
                    }
            }

    }