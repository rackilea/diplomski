row.createCell(2); //This will insert in second column
if(!attributes.getJSONObject(i).isNull("Second")) {
    row.getCell(2).setCellValue(attributes.getJSONObject(i).getString("Second"));
} else {
    row.getCell(2).setCellValue("");
}