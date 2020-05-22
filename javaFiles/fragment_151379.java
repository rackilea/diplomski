import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Test{
    public static void main(String[] args) {
        String word = "diid";
        Stack<Character> s = new Stack<>();
        Queue<Character> q = new LinkedList<>();
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            s.push(letter);
            q.add(letter);
          }

          while (!s.isEmpty()) {
            if (s.pop() != q.remove()) {
              System.out.println("Not Palindrome");
              return;
            }
          }
          System.out.println("Palindrome");
    }
}