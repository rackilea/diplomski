String string = "1-50  of 500+";
String[] stringArray = string.split("\\s+");

for (String str : stringArray)
{
    System.out.println(str);
}