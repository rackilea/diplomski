public class Example
{
    private LinkedList aList = new LinkedList();

    public void push(char c) {
        aList.addFirst(c);
    }
    public Object pop() {
        return aList.removeFirst();
    }
    public boolean empty() {
        return aList.isEmpty();
    }
    public static void main(String[] args)  {
        Stack exmpStack = new Stack();
        String ranString = "Dad";
        for (int i = 0; i < ranString.length(); i++)  {
            exmpStack.push(ranString.charAt(i));
        }
        while (!exmpStack.empty())  {
            System.out.print(exmpStack.pop());
        }
    }
}