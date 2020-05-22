class xx
{
public static void main (String[] args)
{   
...
Object[] receiver = m();
System.out.println(receiver.length);  //  size is 2
}
public static Object[] m()
{
String m ="suresh";
return  (new Object[] { m ,new ArrayList().add("PEPE") });
}