String s = "Why $Java Is# Great?";
    String Output= "yhW $avaJ sI# taerG?";
    StringBuilder sb1 = new StringBuilder();
    Stack<Character> stack = new Stack<>();
    for(int i=0; i<s.length();i++){
        char ch = s.charAt(i);
        if(!((ch >='a' && ch<='z') ||
            (ch >='A' && ch <='Z'))){
             while(!stack.isEmpty()){
                 sb1.append(stack.pop());
             }
             sb1.append(ch);
            }else{
                stack.push(ch);
            }
            }
            System.out.println(sb1.toString());
            System.out.println(sb1.toString().equals(Output));
        }