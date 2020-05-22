public static int postFixEvaluation(int[] numValues, String postfix){
    Stack<Integer> evaluateStack = new Stack<Integer>();
    char[] chars = postfix.toCharArray();
    int length = chars.length;
    int currentNumValue =0;
    int currentLocation =0;

    for (int i = 0; i < length; i++){
        char currentChar = chars[i];

        //checks to see if character is a letter
        if (Character.isLetter(currentChar)){
            //replace all letters with values 
            currentLocation = charToNum(currentChar);//this retrieves the location of specific letter
            currentNumValue = (numValues[currentLocation]);//retrieves the value of that location
            evaluateStack.push(currentNumValue);//get the number value of that variable and push it on stack
            System.out.println(Arrays.toString(evaluateStack.toArray()));//prints out stack elements 
        }


        //checks if character is an operator 
        if (isOperator(currentChar)){
            int righthand = evaluateStack.pop();
            int lefthand = evaluateStack.pop();
            switch (currentChar){
            //switches evaluation according to operator 
                case '+': evaluateStack.push(lefthand + righthand); break;
                case '*': evaluateStack.push(lefthand * righthand); break;
                case '-': evaluateStack.push(lefthand - righthand); break;
                case '/': evaluateStack.push(lefthand / righthand); break;
            }
        }
    }
    if (!evaluateStack.isEmpty()){ //as long as the stack is not empty
        return evaluateStack.pop();//returns the result
    } else {
        return 0; //if it is empty returns zero 
    }
}