public static String reverse(String str)
{
    Stack<Character> stack = new Stack<>();
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < str.length(); i++)
        stack.push(str.toCharArray()[i]);
    }


    while(!stack.isEmpty()){
         sb.append(stack.pop());
    }

    return sb.toString();
}