for(int r=0;r<file.length;r++){
    arlist.clear();
    File currentFile=file[r];


    FileInputStream fis = new FileInputStream(currentFile);
    //DataInputStream myInput = new DataInputStream(fis);
    BufferedReader br = new BufferedReader(new InputStreamReader(fis));
    while ((thisline = br.readLine()) != null) {
        al = new ArrayList<String>();
        String strar[] = thisline.split(",");

        for (int j = 0; j < strar.length; j++) {


            al.add(strar[j]);
        }

        arlist.add(al);
        //i++;

    } 

    fis.close();


        HSSFWorkbook hwb = new HSSFWorkbook();
        HSSFSheet sheet = hwb.createSheet("new sheet"+r);

        for (int k = 0; k < arlist.size(); k++) {
            ArrayList<String> ardata = (ArrayList<String>) arlist.get(k);
            HSSFRow row = sheet.createRow((short) k);

            for (int p = 0; p < ardata.size(); p++) {
                //System.out.print(ardata.get(p));
                HSSFCell cell = row.createCell((short) p);
                cell.setCellValue(ardata.get(p).toString());
            }
        }



        FileOutputStream fileOut = new FileOutputStream(libRoot+"/result/output"+r+".xls");
        hwb.write(fileOut);
        fileOut.flush();
        fileOut.close();
        br.close();

        //hwb=null;
        }


        }