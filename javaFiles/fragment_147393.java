long l = System.currentTimeMillis();
p = Pattern.compile("/(article|category)/(\\d+)/");
m = p.matcher("/en/article/123/articleName");
System.out.println("Matches: " + m.find());
System.out.println("Group1: " + m.group(1) + ", Group2: " + m.group(2));
System.out.println("Time taken: " + (System.currentTimeMillis()-l));