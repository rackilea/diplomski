long nt = System.nanoTime();
StringBuilder sb1 = new StringBuilder(400);
for (int i = 0; i < 200; i++) {
    sb1.append("l").append("\n");
}
String strSb1 = sb1.toString();

StringBuilder sb = new StringBuilder(1000000);
for (int i = 0; i < 2500; i++) {
    sb.append(strSb1);
}

System.out.print(sb.toString());
nt = System.nanoTime() - nt;
System.out.print("\nTime(ms): " + (double)nt / 1000000);