public static void main(String args[])
    {
         String s   = "(PART0(PART1(PART2)(PART3)))";
        Stack<StringBuilder> stack = new Stack<StringBuilder>();
        StringBuilder curr = null;
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (c == '(')
            {
                curr = new StringBuilder();
                stack.push(curr);
            }
            else if (c == ')')
            {
                System.out.println(stack.pop());
            }
            else
            {
                curr.append(c);
            }
        }
    }