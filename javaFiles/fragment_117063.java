// Validate expression format here
// Example: <number> <operator> <number> <=>
//             1          *        5      =

final boolean isValidated = isValidExpression( /* expression */ );

if ( isValidated == true )
{
    final String op = /* get operator here */;
    switch ( op )
    {
        case "+":
            result = addition.calculate();
            break;

        case "-":
            result = subtraction.calculate();
            break;

       // ... /, *, % ...

        default:
            // ERROR: Invalid operator...
    }
}