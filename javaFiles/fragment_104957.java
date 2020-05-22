long X = 500;
NavigableSet<Long> foo = new TreeSet<Long>();

foo.add(450L);
foo.add(451L);    
foo.add(499L);
foo.add(501L);
foo.add(550L);

System.out.println(foo.floor(X));   // 499