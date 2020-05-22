public void csv2excel(String csv) throws Exception
    {
        String inputCSVFile = csv + ".csv";
        ArrayList arList=null;
        ArrayList al=null;
        String fName = inputCSVFile;
        String thisLine; 
        int count=0; 
         FileInputStream fis = new FileInputStream(fName);
         DataInputStream myInput = new DataInputStream(fis);
        int i=0;
        arList = new ArrayList();
        while ((thisLine = myInput.readLine()) != null)
        {
         al = new ArrayList();
         StringBuilder myLine = new StringBuilder(thisLine);
         int lineLength = thisLine.length();
         int bool = 0;
         for (int k = 0; k < lineLength; k++)
         {
             if (thisLine.charAt(k) == '"')
             {
                 bool++;
             }
             else if (thisLine.charAt(k) == ',' && bool % 2 != 0)
             {
                 myLine.setCharAt(k, ' ');
             }
         }

         //System.out.println(myLine);
         //String ab = thisLine.replaceAll(", ", " ");
         String strar[] = myLine.toString().split(",");
         for(int j=0;j<strar.length;j++)
         {
         al.add(strar[j]);
         }
         arList.add(al);
         i++;
        } 
        try
        {
         HSSFWorkbook hwb = new HSSFWorkbook();
         HSSFSheet sheet = hwb.createSheet("new sheet");
          for(int k=0;k<arList.size();k++)
          {
           ArrayList ardata = (ArrayList)arList.get(k);
           HSSFRow row = sheet.createRow((short) 0+k);
           for(int p=0;p<ardata.size();p++)
           {
            HSSFCell cell = row.createCell((short) p);
            String data = ardata.get(p).toString();
            if(data.startsWith("=")){
             cell.setCellType(CellType.STRING);
             data=data.replaceAll("\"", "");
             data=data.replaceAll("=", "");
             cell.setCellValue(data);
            }else if(data.startsWith("\"")){
                data=data.replaceAll("\"", "");
                cell.setCellType(CellType.STRING);
                cell.setCellValue(data);
            }else{
                data=data.replaceAll("\"", "");
                cell.setCellType(CellType.NUMERIC);
                cell.setCellValue(data);
            }
            //*/
         //   cell.setCellValue(ardata.get(p).toString());
           }
          } 
         FileOutputStream fileOut = new FileOutputStream(csv + ".xls");
         hwb.write(fileOut);
         fileOut.close();
        } catch ( Exception ex ) {
             ex.printStackTrace();
        }
        myInput.close();
        fis.close();
    }