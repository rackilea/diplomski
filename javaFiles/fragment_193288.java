String line = s.nextLine()

if (line.startsWith("type"))
{
    String value = line.substring(8);
    System.out.println(value);
}