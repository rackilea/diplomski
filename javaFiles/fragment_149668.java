for (TypeDeclaration<?> typeDec : cu.getResult().get().getTypes()) {
    for (MethodDeclaration method : typeDec.getMethods()) {
        method.getBody().ifPresent(blockStatement -> {
            List<FieldAccessExpr> results = blockStatement.findAll(FieldAccessExpr.class);
                for( FieldAccessExpr expr : results ) {
                    System.out.println(expr.getName());
                }