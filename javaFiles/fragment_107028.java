ClassBody:
  { {ClassBodyDeclaration} }

ClassBodyDeclaration:
  ClassMemberDeclaration 
  InstanceInitializer 
  StaticInitializer 
  ConstructorDeclaration

ClassMemberDeclaration:
  FieldDeclaration 
  MethodDeclaration 
  ClassDeclaration 
  InterfaceDeclaration 
  ;