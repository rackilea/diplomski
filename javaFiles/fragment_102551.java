AST ast = ... // some ast 
Type oldType = ... // existing type from ast
String name = ... // The name of the new type
Type newType = ast.newSimpleType(ast.newName(name));
if (oldType.isParameterizedType()) {
    ParameterizedType newParameterizedType = ast.newParameterizedType(newType);
    for (Object type : ((ParameterizedType) oldType).typeArguments()) {
         type.remove(); // <-- THIS LINE SOLVES THE PROBLEM
         newParameterizedType.typeArguments().add(type);
    }
    newType = newParameterizedType; // use parameterized type
}