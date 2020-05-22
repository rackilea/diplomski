String expandFormula(String s){
    Stack<Character> stack = new Stack();
    Stack<Character> hanoi = new Stack();
    char[] ca = s.toCharArray();
    Character c;
    List<Integer> multipliers = new ArrayList();
    String multiBuff;

    int val;
    boolean flag;

    for (int i = 0; i < ca.length; i++)
        stack.push(ca[i]);

    while(!stack.isEmpty()){
        c = stack.pop();
        if (Character.isLetter(c)){ 
            try{
                //previous parse was end of Symbol, implicit "1"
                flag = Character.isUpperCase(hanoi.peek());
            }
            catch(EmptyStackException ese){ //change exception
                flag = false;
            }
            //push implicit 1
            if (flag){
                stack.push(c);
                stack.push('1');
            }
            //continue as usual
            else
                hanoi.push(c);
        }
        //begin number parsing
    else if(Character.isDigit(c)){
            flag = false;
            multiBuff = c +"";
            //parse the integer out
            while(Character.isDigit(stack.peek())){
                c = stack.pop();
                multiBuff = c + multiBuff;
            }
            //if next char is ), then value is a suffix
            if (stack.peek() == ')'){
                flag = true;
                stack.pop();
                multipliers.add(Integer.parseInt(multiBuff));
                //pop successive )s
                while(stack.peek() == ')'){
                    stack.pop();
                    multipliers.add(1);
                }
            }
            if(Character.isLetter(stack.peek())){
                val = flag ? 0 : Integer.parseInt(multiBuff);
                //get full value of 
                for(Integer i : multipliers){
                    if (val == 0)
                        val = i;
                    else
                        val *= i;
                }
                //trim and push first decibit
                while(val > 0){
                        hanoi.push(Character.forDigit(val % 10, 10));
                        val /= 10;
                }
            }
        }
        //end of nest, remove most recent multiplier
        else if(c == '(')
            try{
                multipliers.remove(multipliers.size()-1);
            }
            catch(ArrayIndexOutOfBoundsException aioobe){

            }
    }
    multiBuff = "";
    while(!hanoi.isEmpty())
        multiBuff += hanoi.pop();

    return multibuff;        
}