Pattern pattern = Pattern.compile("(?:call (?i)name)|(?:(?i)name \\(.*)");

System.out.println(pattern.matcher("call NAME").matches());
System.out.println(pattern.matcher("call name").matches());
System.out.println(pattern.matcher("CALL name").matches());
System.out.println(pattern.matcher("NAME (blablabla").matches());
System.out.println(pattern.matcher("name (blablabla").matches());