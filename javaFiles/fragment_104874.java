import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;
import java.util.ArrayList;


class IterativeEvaluator2
{ 
    private ExpressionScanner expression;

     public IterativeEvaluator2 (String expression)
    {
        this.expression = new ExpressionScanner(expression);
    }

    public double evaluate(Queue<Double> operandqueue)
    {
            // write your code here to create an explicit context stack
        Stack<Queue> temp_stack = new Stack<Queue>();

        char operator = ' ';
            double operand = 0.0;
        int a;

            // write your code here to evaluate the LISP expression iteratively
            // you will need to use an explicit stack to push and pop context objects

        while ( expression.hasNextOperator() || expression.hasNextOperand() )
        {

            // Get the open bracket         

            if ( expression.hasNextOperator())    
                {
                operator = expression.nextOperator() ;

                if (operator == '(')
                { 
                    temp_stack.push(operandqueue);
                    operandqueue = new LinkedList<Double>();
                }

                // push the list into the stack after the closing bracket appears       
                else if (operator == ')')
                {   
                    if (operandqueue.size() > 1 ) {
                        //System.out.println("new opqueue");
                        //System.out.println(operandqueue); 
                        operand = calculate(operandqueue);
                        System.out.println(operand);

                        if (temp_stack.peek() != null)
                        {   
                            operandqueue = temp_stack.pop();
                        //System.out.println(operandqueue);
                            operandqueue.offer(operand);
                        }
                    }
                    else if (operandqueue.size() == 1)
                        operandqueue = temp_stack.pop();
                }
            // if it is another operator then it must be +,-,/,*
                else 
                {
                    operandqueue.offer( (double) operator );
                }
            }
            // else it is an operand so just put it in the queue
            else 
            {
                a= expression.nextOperand() ; 
                //System.out.println(a);
                operandqueue.offer( (double) a );

            }
        }
        return operand;
    }

    private double calculate(Queue<Double> some_queue)
    {
            char operator = (char) some_queue.remove().intValue();
            //System.out.println(operator);
            double operand1 = 0;
            double operand2;            
            switch(operator){
            case '+' :  while( !some_queue.isEmpty() )
                    {
                        operand2 = some_queue.remove();
                        operand1 = operand1 + operand2;
                    }
                    break;

            case '-' :  operand1 = some_queue.remove();
                    //checks for negative numbers
                    if (some_queue.isEmpty() ){
                        operand1 = 0  -  operand1;
                        } 
                    else{
                        while ( !some_queue.isEmpty() )
                        {
                            operand2 = some_queue.remove();
                            operand1 =  operand1 - operand2;
                            System.out.println(operand1);
                        }

                    }
                    break;

            case '*' :  if (!some_queue.isEmpty() )
                    {
                        operand1 = 1;
                        while ( !some_queue.isEmpty() )
                        {
                            operand2 = some_queue.remove();
                            operand1 = operand1*operand2;
                        }
                    }
                    break;

            case '/' :  operand1 = some_queue.remove();
                    if (some_queue.isEmpty() )
                                                operand1 = 1/operand1 ;
                                    else{
                                            while (!some_queue.isEmpty() )
                        {
                                operand2 = some_queue.remove();
                            operand1 = operand1/operand2;                                                                                               }
                    }
                    break;
            }
        return operand1;
    }

    public static void main(String [] args)
    {
        String s =  
        "(+\t(- 6)\n\t(/\t(+ 3)\n\t\t(- \t(+ 1 1)\n\t\t\t3\n\t\t\t1)\n\t\t(*))\n\t(* 2 3 4))";  // = 16.5
        IterativeEvaluator2 myEvaluator = new IterativeEvaluator2(s);
        System.out.println("Evaluating LISP Expression:\n" + s);
        System.out.println("Value is: " + myEvaluator.evaluate(null)); 
    }
}  /* 201340 */