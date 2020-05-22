String str = "1: My street";
String str2 = "3: Hello there world!";

String[] arr = str.split("(?<=:) ");
String[] arr2 = str2.split("(?<=:) ");

System.out.printf("%s%30s\n", arr[0], arr[1]);
System.out.printf("%s%30s", arr2[0], arr2[1]);