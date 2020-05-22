MethodTree methodTree = (MethodTree) tree;
  for (VariableTree parameter : methodTree.parameters()) {
    Type parameterType = parameter.type().symbolType();
    if (parameterType.isArray()) {
      Type.ArrayType arrayType = (Type.ArrayType) parameterType;
      if (arrayType.elementType().symbol().metadata().isAnnotatedWith("MyAnnotation")) {
        // do something
      }
    }
  }