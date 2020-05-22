System.out.println("----BEFORE:");
String records = "foo    bar   baz\rABC\nDEF\t\tGHI";
System.out.println(records);
records = records.replaceAll("[\\s&&[^\r\n]]+", " ");
System.out.println("----AFTER:");
System.out.println(records);