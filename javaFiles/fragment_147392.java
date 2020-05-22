long l = System.currentTimeMillis();
Pattern p = Pattern.compile("^.*?/(article|category)/(\\d+)/.*$");
Matcher m = p.matcher("/category/1012/Grafy");
System.out.println("Matches: " + m.matches());
System.out.println("Group1: " + m.group(1) + ", Group2: " + m.group(2));
System.out.println("Time taken: " + (System.currentTimeMillis()-l));