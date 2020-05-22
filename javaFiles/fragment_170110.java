for (int i = trimmedInput.length-1; i >= 0; i--) {
    if (isNumeric(trimmedInput[i])) stack.push(trimmedInput[i]);

    else if (trimmedInput[i].equals("*")) {
        // here you might get StackEmptyException if your expression is invalid
        // if you want to avoid that, then use try-catch and throw your custom InvalidExpressionExceptiono
        number1 = Integer.parseInt((String)stack.pop());
        number2 = Integer.parseInt((String)stack.pop());
        output = number1*number2;
        stack.push(output);
    }
    .
    .
    . // do the same for other operators
    .
    .
}