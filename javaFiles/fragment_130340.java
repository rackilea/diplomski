import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FCStack<T> {

  public static void main(String[] args) {
    FCStack<String> ops = new FCStack<String>(10);
    FCStack<Double> vals = new FCStack<Double>(10);
    Scanner console = new Scanner(System.in);
    try {
      while (console.hasNext()) {
        String str = console.next().trim();
        if (str.equals(".")) {
           System.out.println(vals.peek());
         } else if (str.equals("(")) {
            ;
         } else if (str.equals("+")) {
           ops.push(str);
         } else if (str.equals("-")) {
           ops.push(str);
         } else if (str.equals("*")) {
           ops.push(str);
         } else if (str.equals("/")) {
           ops.push(str);
         } else if (str.equals("^")) {
           ops.push(str);
         } else if (str.equals(")")) {
           String op = ops.pop();
           double v = vals.pop();
           if (op.equals("+")) {
             v = vals.pop() + v;
           } else if (op.equals("-")) {
             v = vals.pop() - v;
           } else if (op.equals("*")) {
             v = vals.pop() * v;
           } else if (op.equals("/")) {
             v = vals.pop() / v;
           } else if (op.equals("^")) {
             v = Math.pow(v, vals.pop());
          }
          vals.push(v);
        } else {
          vals.push(Double.parseDouble(str));
        }
     }
  } finally {
    console.close();
  }
}

private List<T> a;
private int top; // pointer to top of FCStack
private int capacity; // size of the FCStack+1

public FCStack(int cap) {
  capacity = cap;

  a = new ArrayList<T>();
  top = 0;
}

public void push(T i) { // will only push an Item to
                      // the FCStack if there is room.
  if (!isFull()) {
    a.add(i);
    ++top;
  }
}

public T pop() { // will only pop an Item from the
                 // stack if there is something to pop.
  if (!isEmpty()) {
    return a.remove(--top);
  }
  return null;
}

public T peek() {
  if (!isEmpty()) {
    return a.get(top - 1);
  }
  return null;
}

public boolean isFull() { // returns true if is full
  return top > capacity;
}

public boolean isEmpty() { // returns true if is empty
  return top == 0;
}

  public int size() { // returns the current size of the
                      // stack+1 or the array index
    return top;
  }
}