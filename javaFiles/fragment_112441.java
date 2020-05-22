String str = "-2.100 CM 1.000 CM 1.025 CM";

String[] array = str.split("\\s+CM\\s*");
for (String s : array) {
    System.out.println(new Double(s));
}