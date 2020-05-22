static class MyEvaluator extends FastEvaluator {
    private static final long serialVersionUID = 1L;

    @Override
    public Object visit(ASTVarNode node, Object data) throws EvaluationException {
        Variable var = node.getVar();
        if(!var.hasValidValue())
            throw new EvaluationException("Value not set");
        return super.visit(node, data);
    }
}