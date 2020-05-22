Scanner scanner1 = new Scanner("a[");
assert(scanner1.hasNext("a\\[")); 

Scanner scanner2 = new Scanner("[[0]]");
assert(scanner2.hasNext("\\[.*"));  

Scanner scanner3 = new Scanner(" a[[[0]]");
assert(scanner3.hasNext("a\\[.*"));