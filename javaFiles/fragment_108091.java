boolean parse_Goal()
{  if parse_Assignement()
   then return true
   else return false
}

boolean parse_Assignment()
{  if not Parse_LHS()
   then return false
   if not Parse_equalsign()
   then throw SyntaxError // because there are no viable alternatives from here
   if not Parse_RHS()
   then throw SyntaxError
   if not Parse_semicolon()
   the throw SyntaxError
   return true
}

boolean parse_LHS()
{  if parse_IDENTIFIER()
   then return true
   else return false
}

boolean parse_RHS()
{  if parse_IDENTIFIER()
   then return true
   if parse_NUMBER()
   then return true
   else return false
}

boolean parse_equalsign()
{  if TestInputAndAdvance("=")  // this can check for token instead
   then return true
   else return false
}

boolean parse_semicolon()
{  if TestInputAndAdvance(";")
   then return true
   else return false
}

boolean parse_IDENTIFIER()
{  if TestInputForIdentifier()
   then return true
   else return false
}

boolean parse_NUMBER()
{  if TestInputForNumber()
   then return true
   else return false
}