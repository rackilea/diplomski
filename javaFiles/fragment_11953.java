String line = scanner.nextLine();

String[] tokens = line.split("\\s+");
String value1 = tokens[tokens.length-2];
String value2 = tokens[tokens.length-1];

String rowTitle = line.substring(0, line.indexOf(value1)).trim();

System.out.print(rowTitle + "\t");
System.out.print(value1 + "\t");
System.out.println(value2);