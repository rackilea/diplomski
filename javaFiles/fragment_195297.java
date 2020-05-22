static Scanner console = new Scanner(System.in);  
public static void main (String[] args)  
{  
    int totalChar;  
    int numOfLines = console.nextInt(); 
    int charPerLine = console.nextInt(); // keep your variable names consistent by using either "charPerLn" or "charPerLine", not both :)
    char symbol = console.next().charAt(0);  

    System.out.println("# of lines: " + numOfLines);
    System.out.println("# of characters: " + charPerLine);
    System.out.println("Character: " + symbol);
    System.out.println(getPattern( /* [use, the, parameters, from, above, here] */ ));

    totalChar = numOfLines * charPerLine; // first assign to totalChar, then you can print it
    System.out.println("Total Characters: " + totalChar);
}

public static String getPattern(int numOfLines, int charPerLine, char symbol) // you want to return a string, so we change "int" to "String" here
{
    String pattern = "";

    /* As "that other guy" said, nested for loops go here */
    for(/* ... */)
    {
        /* ... */
        for(/* ... */)
        {
         /* ... */
        }
        /* ... */
    }

    return pattern;
}