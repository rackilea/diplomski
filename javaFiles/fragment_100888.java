void Start(PrintStream printStream) throws NumberFormatException :
{}
{
    (
        previousValue = Expression()
        (<EOL>)*
        {printStream.println(previousValue) ; }
    )*
    <EOF>
}