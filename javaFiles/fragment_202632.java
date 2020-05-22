import java.util.*;

 class ParenthesisMatching
 {
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        Stack<Integer> stk = new Stack<Integer>();
        System.out.println("Enter expression");
        String exp = scan.next();        
        if(isValid(exp))
            System.out.println("matched");
        else System.out.println("unmatched");
    }

    public static boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (map.keySet().contains(curr)) {
                stack.push(curr);
            } else if (map.values().contains(curr)) {
                if (!stack.empty() && map.get(stack.peek()) == curr) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.empty();
    }  
 }