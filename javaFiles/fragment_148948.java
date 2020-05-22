String array[] = new String[3];
String x = "*";
for (int i= 0; i < array.length; i++)
{
    array[i] = "";
    array[i] = array[i] + x;
    system.out.println(array[i]);
    x = x + "*";
}