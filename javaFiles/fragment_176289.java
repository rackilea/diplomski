for (int x=0; x<sheet.getLastRowNum()+1; x++){
            Row row=sheet.getRow(x);
            int y=0; 
            for (Cell c : row){
                // int y=0; every time its init with 0 so value would be override on every time 
                s[x][y]=c.getStringCellValue();
//              System.out.println(s[x][y]);
                y++;
            }           
        }