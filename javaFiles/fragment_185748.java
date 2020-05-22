QueryTranslator[] translators = hqlPlan.getTranslators();
AST ast = (AST)((QueryTranslatorImpl)translators[0]).getSqlAST();
    new NodeTraverser(new NodeTraverser.VisitationStrategy() {
    public void visit(AST node) {
        if(node.getType() == SqlTokenTypes.FROM_FRAGMENT || node.getType() == SqlTokenTypes.JOIN_FRAGMENT) {
            FromElement id = (FromElement)node;
            System.out.println(node+": "+id.getClassAlias()+" - "+id.getClassName());
        }
    }
}).traverseDepthFirst(ast);