public static List<User> getdata() throws IOException {
    List<User> data = new ArrayList<>();

    FileInputStream fis = new FileInputStream("C:\\Users\\vnaditya\\Downloads\\Book2.xlsx");
    XSSFWorkbook XS = new XSSFWorkbook(fis);
    int numberofsheets = XS.getNumberOfSheets();

    for (int i = 0; i < numberofsheets; i++) {
        if (XS.getSheetName(i).equalsIgnoreCase("Sheet1")) {

            XSSFSheet XSS = XS.getSheetAt(i);
            Iterator<Row> r = XSS.iterator();

            String username, emailIDs, phone, location;
            User user;
            while (r.hasNext()) {
                Row row = r.next();
                username = row.getCell(0).getStringCellValue();
                emailIDs = row.getCell(1).getStringCellValue();
                phone = row.getCell(2).getStringCellValue();
                location = row.getCell(3).getStringCellValue();
                user = new User(username, emailIDs, phone, location);
                data.add(user);
            }
        }
    }
    return data;
}