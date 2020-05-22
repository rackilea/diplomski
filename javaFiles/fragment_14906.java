File sv= null;

        JFileChooser chooser = new JFileChooser();
            int returnVal = chooser.showSaveDialog(null);
            if(returnVal == JFileChooser.APPROVE_OPTION) {

               sv= chooser.getSelectedFile();


            }
           else{

            // no file has been chosen
            return;
           }

    while (rs052.next()) {
        HSSFRow row = sheet.createRow((short) i);
        row.createCell((short) 0).setCellValue(rs052.getString("found"));
        row.createCell((short) 1).setCellValue(rs052.getString("name"));
        row.createCell((short) 2).setCellValue(Integer.toString(rs052.getInt("pid")));
        i++;



    }

    FileOutputStream fileOut = new FileOutputStream(sv);
    workbook.write(fileOut);
    fileOut.close();