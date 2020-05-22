functionDeclaration
  :  'function' LT* Identifier LT* formalParameterList LT* functionBody 
     -> ^(FUNCTION Identifier formalParameterList functionBody)
  ;

functionExpression
  :  'function' LT* Identifier? LT* formalParameterList LT* functionBody 
     -> ^(FUNCTION Identifier? formalParameterList functionBody)
  ;

variableDeclaration
  :  Identifier LT* initialiser? 
     -> ^(VARIABLE Identifier initialiser?)
  ;