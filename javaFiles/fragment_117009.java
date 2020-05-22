String str = "Item A (UNIT OF FACTOR)", str1= "Item A (B)";;
str =   str.replaceAll("\\([^)]*OF[^)]*\\)", "");
str1 =  str1.replaceAll("\\([^)]*OF[^)]*\\)", ""); 
System.out.println(str);
System.out.println(str1);


str = "Item A (UNIT OF FACTOR)";
str1 = "Item A (B)";
str =   str.replaceAll("\\([^)]*(?=OF).*\\)", ""); // Using postive look ahead
str1 =  str1.replaceAll("\\([^)]*(?=OF).*\\)", ""); // Using postive look ahead
System.out.println(str);
System.out.println(str1);