final String pw = "pw:(abc)";

final String anon = pw.replaceAll("[^pw:]", "*");

System.out.println(pw);
System.out.println(anon);