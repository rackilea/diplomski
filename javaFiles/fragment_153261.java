class Lexer
void init()
{
    do
        try
        {
            line = buf.readLine ().trim ();
            if (! line.endsWith (";"))
                line = String.format ("%s;", line);
        }
        catch(Exception e)
        {
            System.out.println("Error in input");
            System.exit (1);
        }
    while (line.length () == 0);
}

{
    // ...  
    Lexer ()
    {
        buf = new BufferedReader (new InputStreamReader(System.in));
    }

    Lexer (String s)
    {
        buf = new BufferedReader (new StringReader (s));
    }