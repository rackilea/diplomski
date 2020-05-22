String stringTest = "test String";

 StringBuffer normalTest = new StringBuffer(stringTest);
 normalTest = normalTest.append(" end");
 normalTest.delete(0, 5);
 System.out.println(normalTest);

 final StringBuffer finalTest = new StringBuffer(stringTest);
// finalTest = finalTest.append(" end"); // can't work;
 finalTest.delete(0, 5);
 System.out.println(finalTest);