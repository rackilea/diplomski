Row[] dataRows = d2.collect();
    for (Row row : dataRows) {
        System.out.println("Row : "+row);
         for (int i = 0; i < row.length(); i++) {
                System.out.println("Row Data : "+row.get(i));
         }
    }