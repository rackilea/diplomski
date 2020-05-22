private ArrayList<DVRecord> init(FileInputStream fis) throws InvalidFormatException, IOException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
    HSSFWorkbook hWorkbook = (HSSFWorkbook) WorkbookFactory.create(fis);
    HSSFSheet hSheet = hWorkbook.getSheetAt(1); // sheet on which you want to read data validation
    Class c = org.apache.poi.hssf.usermodel.HSSFSheet.class;
    Field field = c.getDeclaredField("_sheet");
    field.setAccessible(true);
    Object internalSheet = field.get(hSheet);
    InternalSheet is = (InternalSheet) internalSheet;
    DataValidityTable dvTable = is.getOrCreateDataValidityTable();
    Class c2 = org.apache.poi.hssf.record.aggregates.DataValidityTable.class;
    Field field2 = c2.getDeclaredField("_validationList");
    field2.setAccessible(true);
    Object records = field2.get(dvTable);
    ArrayList<DVRecord> dvRecords = (ArrayList<DVRecord>) records;
    return dvRecords;
}