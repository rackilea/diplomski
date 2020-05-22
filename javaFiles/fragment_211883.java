public static int evaluate(Scanner input)
    {
        if (input.hasNextInt())
        {
            int stack_top_value=input.nextInt();
            stack_for_operand.push(stack_top_value);
            return stack_top_value;
        }
        else
        {
            String operator = input.next();
            stack_for_operator.push(operator);

            int operand1 = evaluate(input);
            int operand2 = evaluate(input);
            return evaluate(operator, operand1, operand2);
        }
    }