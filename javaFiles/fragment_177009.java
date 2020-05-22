// While there are characters to consume.
    for(int ch; (ch = input.read()) != -1;)
    {
        // Create an operator and operand stack                         
        operatorStack opStack = new operatorStack();
        opStack.push(';');
        operandStack intStack = new operandStack();

        token = (char)ch; // Get the token

        if(token == '\r' || token == '\n')  // handling line ends.
             continue;

        if(Character.isDigit(token))
        {
            System.out.print(token);
            intStack.push(token);
        }
        else if(token == ')')
        {........