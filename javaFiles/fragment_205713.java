File file = new File("test.xlsm");
    FileInputStream inputStream = new FileInputStream(file);
    OPCPackage.open(inputStream);
    ......
    FileOutputStream fileOut=new FileOutputStream("test.xlsm");
    wb.write(fileOut);
    fileOut.close();