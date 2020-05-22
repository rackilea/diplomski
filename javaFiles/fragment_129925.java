Name name = template.getName("personal_business_name");
        AreaReference aref = new AreaReference(name.getRefersToFormula());
        CellReference ref = aref.getFirstCell();
        Row r = sheet.getRow(ref.getRow());
        Cell c;
        if (r != null) {
        c = r.getCell(ref.getCol());
        c.setCellValue(buyers.get(transactions.get(transactionNo-1).getBuyerId()-1).getSurname_organization() + ", " + buyers.get(transactions.get(transactionNo-1).getBuyerId()-1).getFirstname());
        }