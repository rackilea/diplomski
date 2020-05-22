public Response addindUserToTable(XSSFSheet mySheet) {
UserTravelBo userBO = null;
Iterator<Row> rowIterator = mySheet.iterator();
//int j = 0; Here i was doing wrong
while (rowIterator.hasNext()) {
    userBO = new UserTravelBo();//creating a new object for each row.
    Row row = rowIterator.next();
    if(row.getRowNum()==0){
           continue; //just skip the rows if row number is 0 because it is   heading
     }
    else{
    int j = 0;//Here j should be initiated
    Iterator<Cell> cellIterator = row.cellIterator();
    while (cellIterator.hasNext()) {
        Cell cell = cellIterator.next();

        switch (j) {
        case 0:
            userBO.setUsername(cell.getStringCellValue());
            System.out.println("Excel"+cell.getStringCellValue());
            break;
        case 1:
            userBO.setPassword(cell.getStringCellValue());
            break;
        case 2:
            userBO.setHint(cell.getStringCellValue());
            break;
        case 3:
            userBO.setFirstname(cell.getStringCellValue());
            break;
        case 4:
            userBO.setMiddlename(cell.getStringCellValue());
            break;
        case 5:
            userBO.setLastname(cell.getStringCellValue());
            break;
        case 6:
            userBO.setStreet(cell.getStringCellValue());
            break;
        case 7:
            userBO.setArea(cell.getStringCellValue());
            break;
        case 8:
            userBO.setCity(cell.getStringCellValue());
            break;
        case 9:
            userBO.setState(cell.getStringCellValue());
            break;
        case 10:
            userBO.setCountry(cell.getStringCellValue());
            break;
        case 11:
            userBO.setPostalcode(cell.getStringCellValue());
            break;
        case 12:
            userBO.setTelephone(cell.getStringCellValue());
            break;
        case 13:
            userBO.setEmail(cell.getStringCellValue());
            break;
        case 14:
            userBO.setRolename(cell.getStringCellValue());
            break;
        case 15:
            userBO.setStatus(cell.getBooleanCellValue());
            break;

        default:
            break;
        }
        j++;
    }
}
    System.out.println(userBO.getUsername());//for first row getting valid    output but for the second row i am getting null.
    addUser(userBO);
}
return Response.ok("file uploaded and added to table").build();
}