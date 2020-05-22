public static void main(String[] args) 
{
    evaluate("128+16+8+2+1");
}

public static void evaluate(String equation)
{
    String[] numbers = equation.split("\\+");

    int sum = 0;

    for (String number : numbers)
    {
        //could wrap this in a check incase of exception or errors
        sum += Integer.parseInt(number);
    }

    System.out.println(sum);
}