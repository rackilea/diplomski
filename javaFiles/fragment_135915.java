IMethodBinding binding = node.resolveMethodBinding();        
    ITypeBinding typeBinding = expression.resolveTypeBinding();
    ITypeBinding type = binding.getDeclaringClass();        
    Expression expression = node.getExpression();


    System.out.println("Type: " + typeBinding.getName());