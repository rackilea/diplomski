if (tableRow.hasText()){
    String rowData = tableRow.text();
    if(rowData.contains(testString)){
        tableRowStrings.add(rowData);
    }
}