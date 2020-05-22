Set<List<String>> keySet = new HashSet<>();
for (int i = 0; i <= totalrows; i++) {
    for (int j = 0; j < sheet.getRow(0).getPhysicalNumberOfCells(); j++) {
        HSSFCell cell = sheet.getRow(i).getCell(j);
        // writing keywords from excel into a hashmap

        data[i][j]=cell.getRichStringCellValue().getString();
    }
    keySet.add(Arrays.asList(data[i]));
}
Iterator<List<String>> iterator = keySet.iterator();
System.out.println("Output Set is as below");
while(iterator.hasNext()){
    List<String> next = iterator.next();
    System.out.println(next.get(0) + "\t"+ next.get(1) +"\t "+next.get(2));
}