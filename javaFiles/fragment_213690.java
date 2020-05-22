System.out.println("xHello".matches("Hello"));
   // false: no match
   System.out.println("xHello".matches(".*Hello"));
   // true: match
   System.out.println("sdfTestLtd ".matches("Ltd[.'s]{0,2}"));
   // false: no match