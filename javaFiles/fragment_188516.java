public class Example
{
    private LinkedList aList = new LinkedList();

    public static void main(String[] args)  {
        String ranString = "Dad";
        for (int i = 0; i < ranString.length(); i++)  {
            aList.push(ranString.charAt(i));
        }
        while (!aList.isEmpty())  {
            System.out.print(aList.pop());
        }
    }
}