public static boolean checkPass(String password) {

    Stack<Character> stack = new Stack<Character>();
    int count1 = 0, count2 = 0;
    if (password.length() < 8) {
        return false;
    } else {
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);

            if (!Character.isLetterOrDigit(c)) {
                return false;
            } else {
                stack.push(c);
            }
        }
        while(!stack.isEmpty()){
            char c = stack.pop();
            if(Character.isLetter(c)){
                count1++;
            }else{
                count2++;
            }
        }
        return count1 == count2;
    }
}