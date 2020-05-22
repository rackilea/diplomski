String w1 = "word";
String w2 = "word";
String b = new String("word"); // explicitly created String (by `new` operator) 
                               // won't be placed in string pool automatically
System.out.println(w1 == w2);  // true  -> variables hold same reference
System.out.println(w1 == b);   // false -> variable hold different references,
                               // so they represent different objects
b = b.intern(); // checks if pool contains this string, if not puts this string in pool, 
                // then returns reference of string from pool and stores it in `b` variable
System.out.println(w1 == b);   // true  -> now b holds same reference as w1