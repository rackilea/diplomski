AST* parse_Goal() // note: we choose to return a null pointer for "false"
{  node = parse_Assignment()
   if node != NULL
   then return node
   else return NULL
}

AST* parse_Assignment()
{  LHSnode = Parse_LHS()
   if LHSnode == NULL
   then return NULL
   EqualNode = Parse_equalsign()
   if EqualNode == NULL
   then throw SyntaxError // because there are no viable alternatives from here
   RHSnode = Parse_RHS()
   if RHSnode == NULL
   then throw SyntaxError
   SemicolonNode = Parse_semicolon()
   if SemicolonNode == NULL
   the throw SyntaxError
   return makeASTNode(ASSIGNMENT,LHSNode,RHSNode)
}

AST* parse_LHS()
{  IdentifierNode = parse_IDENTIFIER()
   if node != NULL
   then return IdentifierNode
   else return NULL
}

AST* parse_RHS()
{  RHSnode = parse_IDENTIFIER()
   if RHSnode != null
   then return RHSnode
   RHSnode = parse_NUMBER()
   if RHSnode != null
   then return RHSnode
   else return NULL
}

AST* parse_equalsign()
{  if TestInputAndAdvance("=")  // this can check for token instead
   then return makeASTNode("=")
   else return NULL
}

AST* parse_semicolon()
{  if TestInputAndAdvance(";")
   then return makeASTNode(";")
   else return NULL
}

AST* parse_IDENTIFIER()
{  text = TestInputForIdentifier()
   if text != NULL
   then return makeASTNode("IDENTIFIER",text)
   else return NULL
}

AST* parse_NUMBER()
{  text = TestInputForNumber()
   if text != NULL
   then return makeASTNode("NUMBER",text)
   else return NULL
}