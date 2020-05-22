String str = "Hadoop";

byte bt1[] = str.getBytes();
System.out.println(bt1.length); // 6

byte bt2a[] = str.getBytes("UTF-16");
System.out.println(bt2a.length); // 14

byte bt2b[] = str.getBytes("UTF-16BE");
System.out.println(bt2b.length); // 14

byte bt3[] = str.getBytes("UTF-16LE");
System.out.println(bt3.length); // 12