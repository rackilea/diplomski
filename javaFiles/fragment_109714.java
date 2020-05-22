public class Main {
    public static void main(String[] args) {
        MyStack<String> myStackA = new MyStack<String>();
        MyStack<String> myStackB = new MyStack<String>();

        myStackA.push("Hello");
        myStackA.push("Hi");

        myStackB.push(myStackA.peek());

        System.out.println(myStackA.peek()); //prints Hi
        System.out.println(myStackB.peek()); //prints Hi
    }
}