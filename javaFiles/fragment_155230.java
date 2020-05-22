LocalVariableDeclarationStatement:
    LocalVariableDeclaration ;

LocalVariableDeclaration:
    VariableModifiersopt Type VariableDeclarators

.......

VariableDeclarator:
    VariableDeclaratorId
    VariableDeclaratorId = VariableInitializer