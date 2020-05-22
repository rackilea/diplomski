//should be ArrayList due to random access. Could also be Guava ImmutableList
final List<BiConsumer<Cell, Employee>> populators = new ArrayList<>();
//add the populators in order
populators.add((c, e) -> e.setEmpId(c.getStringCellValue()));
populators.add((c, e) -> e.setFirstname(c.getStringCellValue()));
populators.add((c, e) -> e.setDob(c.getDateCellValue()));
//pass constructor as producer
final SheetReader<Employee> reader = new SheetReader<>(Employee::new, populators);
//can read many sheets of same type with same reader
final List<Employee> employees = reader.readSheet(sheet, true);