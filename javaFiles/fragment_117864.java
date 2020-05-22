ConsoleStringTable table= new ConsoleStringTable();
table.addString(0, 0, "AveryVeryVeryLongWord");
table.addString(0, 1, "AnotherWord");
table.addString(1, 0, "Short");
table.addString(1, 1, "Fast");
System.out.println(table.toString());