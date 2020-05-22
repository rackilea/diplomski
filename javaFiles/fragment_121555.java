public static string Convert(string input)
{
    ANTLRStringStream sStream = new ANTLRStringStream(input);
    MyGrammarLexer lexer = new MyGrammarLexer(sStream);

    CommonTokenStream tStream = new CommonTokenStream(lexer);

    MyGrammarParser parser = new MyGrammarParser (tStream);
    MyGrammarParser.program_return parserResult = parser.program();

    CommonTree ast = (CommonTree)parserResult.Tree;

    Print(ast);
    string output = header + body + footer;

    return output;
}

public static void PrintChildren(CT ast)
{
    PrintChildren(ast, " ", true);
}

public static void PrintChildren(CT ast, string delim, bool final)
{
    if (ast.Children == null)
    {
        return;
    }

    int num = ast.Children.Count;

    for (int i = 0; i < num; ++i)
    {
        CT d = (CT)(ast.Children[i]);
        Print(d);
        if (final || i < num - 1)
        {
            body += delim;
        }
    }
}

public static void Print(CommonTree ast)
{
    switch (ast.Token.Text)
    {
        case "PROGRAM":
            //body += header;
            PrintChildren(ast);
            //body += footer;
            break;
        case "GLOBALS":
            body += "\r\n\r\n// GLOBALS\r\n";
            PrintChildren(ast);
            break;
        case "GLOBAL":
            body += "public static ";
            PrintChildren(ast);
            body += ";\r\n";
            break;

      ....
    }
}