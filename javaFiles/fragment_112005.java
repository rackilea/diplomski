public class Stack
{
public static void main(String[] args)
{
    String test = "Username|Name|AccountType|Organization";
    String[] token = test.split("\\|");

    System.out.println(test);
    System.out.println();

    for(int i=0; i<token.length; i++)
    System.out.println(token[i]);

    System.out.println();
}
}