// Test to validate expression with regex
// Example: <number> <operator> <number> <=>
//             1          *        5      =

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ExpressionValidator
{
    public static boolean isValidExpression( final String exp )
    {
        final String regex = "\\d+\\s*[*|/|+|-]\\s*\\d+\\s*[=]";
        final Pattern pattern = Pattern.compile( regex );
        final Matcher matcher = pattern.matcher( exp.trim() );
        return matcher.find();
    }

    public static void main( final String[] args )
    {
        final String[] expressions = 
        {  
            " 1 +  2 =",
            " 3 *  5 =",
            "12 + 10 =",
            " 33 = 25 ",
            " +65  65 ",
            "45 666  ="
        };

        for ( final String exp : expressions )
        {
            System.out.println( "[" + exp + "] >> " + isValidExpression( exp ) );
        }
    }
}