import java.util.*;

public class RPNParser {

    public static void main( String[] args ) {

        String rpnExp = "-4 3 + 5 * 3 - -61 *";
        String[] tokens = rpnExp.split( " " );

        Stack<Integer> stack = new Stack<Integer>();
        Integer op1 = null;
        Integer op2 = null;
        Integer result = null;

        for ( String token : tokens ) {

            if ( token.equals( "+" ) ) {
                op2 = stack.pop();
                op1 = stack.pop();
                stack.push( op1 + op2 );
            } else if ( token.equals( "-" ) ) {
                op2 = stack.pop();
                op1 = stack.pop();
                stack.push( op1 - op2 );
            } else if ( token.equals( "*" ) ) {
                op2 = stack.pop();
                op1 = stack.pop();
                stack.push( op1 * op2 );
            } else if ( token.equals( "/" ) ) {
                op2 = stack.pop();
                op1 = stack.pop();
                stack.push( op1 / op2 );
            } else {
                stack.push( Integer.valueOf( token ) );
            }

        }

        result = stack.pop();
        System.out.printf( "%s = %d\n", rpnExp, result );

    }

}