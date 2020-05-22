code = open('sample.java', 'r').read()
codeStream = InputStream(code)
lexer = JavaLexer(codeStream)

# First lexing way
tokensStream = CommonTokenStream(lexer)
parser = JavaParser(tokensStream)

# Second lexing way
'''tokens = lexer.getAllTokens()
tokensSource = ListTokenSource(tokens)
tokensStream = CommonTokenStream(tokensSource)
parser = JavaParser(tokensStream)'''

tree = parser.compilationUnit()
print "Tree " + tree.toStringTree(recog=parser);