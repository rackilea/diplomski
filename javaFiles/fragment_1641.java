String pattern = "((.)\\2+)+";
System.out.println("a".matches(pattern));        // false
System.out.println("1aaa".matches(pattern));     // false
System.out.println("aa".matches(pattern));       // true
System.out.println("aabb111".matches(pattern));  // true
System.out.println("1111222".matches(pattern));  // true
System.out.println("11222aaa".matches(pattern)); // true
System.out.println("etc.".matches(pattern));     // false