class MyStack<E> {    
    private final Stack<E> wrapped = new Stack<E>();

    public void push(E element) {
        wrapped.push(e);
    }

    public E pop() {
        return wrapped.pop();
    }
}


public class Program {

     public static void main(String[] args) {        

     System.out.println("Stack empty --> top = null, min = null");

     MyStack<String> stack = new MyStack<>();

     stack.push("hello");

     stack.push("world");
}