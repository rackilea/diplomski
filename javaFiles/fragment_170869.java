String s = "ABCdef";// this string will be placed in 
                    // string pool before rest of code

String str1 = "ABC";
String str2 = "def";
String concat1 = str1 + str2;
concat1.intern();//this will only return reference to literal from pool

System.out.println(concat1 == "ABCdef");//false


// here we don't have any "ABcd" literal in pool yet
String strA = "AB";
String strB = "cd";
String concatAB = strA + strB;
concatAB.intern();//so this will put String object from concatAB to pool
System.out.println(concatAB == "ABcd");//and "ABcd" literal will use same object