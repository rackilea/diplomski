int i = 0;
while (matcher.find()) {
   for (int j = 0; j <= matcher.groupCount(); j++) {
      System.out.println("------------------------------------");
      System.out.println("Group " + i + ": " + matcher.group(j));
      i++;
   }
}