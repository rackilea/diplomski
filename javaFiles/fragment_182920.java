TryStatement:
    try ResourceSpecification Block Catchesopt Finallyopt 

Supporting new grammar productions are added:

ResourceSpecification:
    ( Resources ) 
Resources:
    Resource 
    Resource ; Resources 
Resource:
    VariableModifiers Type VariableDeclaratorId = Expression 
    Expression