internal class Program
{
    private static void Main()
    {
        while (true)
        {
            Console.Write("> ");
            var exprText = Console.ReadLine();

            if (string.IsNullOrWhiteSpace(exprText))
                break;

            var inputStream = new AntlrInputStream(new StringReader(exprText));
            var lexer = new MathLexer(inputStream);
            var tokenStream = new CommonTokenStream(lexer);
            var parser = new MathParser(tokenStream);

            try
            {
                var cst = parser.compileUnit();
                var ast = new BuildAstVisitor().VisitCompileUnit(cst);
                var value = new EvaluateExpressionVisitor().Visit(ast);

                Console.WriteLine("= {0}", value);
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }

            Console.WriteLine();
        }
    }
}