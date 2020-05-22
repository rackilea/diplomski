// TODO Auto-generated method stub

    XmlSuite suite = new XmlSuite();
    suite.setName("TmpSuite");

    XmlTest test = new XmlTest(suite);
    test.setName("TmpTest");
    List<XmlClass> classes = new ArrayList<XmlClass>();
    List<XmlSuite> suites = new ArrayList<XmlSuite>();

    FileInputStream file=new FileInputStream(new File("D:\\TestCases.xlsx"));

    XSSFWorkbook workbook=new XSSFWorkbook(file);

    XSSFSheet sheet=workbook.getSheetAt(0);

    for(int i=1; i<sheet.getPhysicalNumberOfRows(); i++){

        if(sheet.getRow(i).getCell(1).getStringCellValue().equals("Y")){


            classes.add(new XmlClass(sheet.getRow(i).getCell(0).getStringCellValue()));

        }

    }

    test.setXmlClasses(classes) ;
    suites.add(suite);
    TestNG tng = new TestNG();
    tng.setXmlSuites(suites);
    tng.run();