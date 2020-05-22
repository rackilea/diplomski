static boolean checkParentheses(String s) {
     int opened = 0;
     for (int i = 0; i < s.length(); i++) {
         if (s.charAt(i) == '(')
             opened++;
         else if (s.charAt(i) == ')') {
             if (opened == 0)    // means that all parentheses are "closed" yet
                return false;
             opened--;
         }
     }
     return opened == 0;
}