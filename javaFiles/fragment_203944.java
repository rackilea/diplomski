System.out.println("    {");
for (int i = 0; i < errorcodesArray.length; i++) {
  System.out.print("      { \"");
  System.out.print(errorcodesArray[i][0]);
  System.out.print("\", \"");
  System.out.print(errorcodesArray[i][1]);
  System.out.print("\"}");
  if (i + 1 < errorcodesArray.length) {
    System.out.print(",");
  }
  System.out.println();
}
System.out.println("    };");