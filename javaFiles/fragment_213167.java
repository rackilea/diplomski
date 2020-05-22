Scanner sc2 = new Scanner("abcd;\nxyz");
while (sc2.hasNextLine())
for (String item : sc2.nextLine().split(";"))
{
  System.out.printf("%s%n", item);
}