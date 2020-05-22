public static void createTableToReplace(Document sourceDocument, int noofCount)
        throws Exception {
    try{
        Document doc = sourceDocument;
        DocumentBuilder builder = new DocumentBuilder(doc);

        Section section = doc.getFirstSection();
        // Quick typed access to the Body child node of the Section.
        Body body = section.getBody();

        // Quick typed access to all Table child nodes contained in the
        // Body.
        TableCollection tables = body.getTables();
        System.out.println(tables.getCount());

        for (Table table : tables.toArray()) {

            // Quick typed access to the first row of the table.
            if (table.getFirstRow() != null) {
                if (table.getFirstRow().toString(SaveFormat.TEXT).trim()
                        .equalsIgnoreCase("~Multiple~")) {

                    for (int i = 0; i < noofCount; i++) {

                        Table cloneTable = (Table)table.deepClone(true);
                        //Remove the first row of table if you want.
                        cloneTable.getFirstRow().remove();
                        table.getParentNode().insertAfter(cloneTable, table);
                        //table.getParentNode().insertAfter(new Paragraph((doc)), table);
                    }
                }
            }

            if (table.getFirstRow() != null) {
                if (table.getFirstRow().toString(SaveFormat.TEXT).trim()
                        .equalsIgnoreCase("~Multiple~")) {
                    for(Row row : table.getRows())
                    {
                        if(row.isFirstRow())
                            continue;
                        else
                            row.remove();
                    }
                    //table.remove();
                }
            }
        }
    }
    catch(Exception e){
        throw e;
    }
}