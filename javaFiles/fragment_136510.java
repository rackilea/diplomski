if(myArray[i].matches(".*\\d.*") && ! myArray[i].contains("-"))    //For date assuming '-' would be a separator always
         {
            //Its a number(int or float).. Excel treats both as numeric

            HSSFCellStyle style = (HSSFCellStyle) wb.createCellStyle();
            style.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00"));
            mycell.setCellStyle(style);
            mycell.setCellValue(Float.parseFloat(myArray[i]));
         }
         else if(myArray[i].contains("-"))
         {
            // Its a date
            CellStyle cellStyle = wb.createCellStyle();
            cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("m/d/yy h:mm"));
            mycell.setCellStyle(cellStyle);
            mycell.setCellValue(myArray[i]);
         }
         else
         {
            // Its a string/Text..
            mycell.setCellValue(myArray[i]);
         }