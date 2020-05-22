Scanner sc1 = new Scanner("abcd;\nxyz");
sc1.useDelimiter("[;\r\n]+");
while (sc1.hasNext())
{
  System.out.printf("%s%n", sc1.next());
}