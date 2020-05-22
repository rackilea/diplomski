public final class VariableResolver extends TemplateVariableResolver {

    public VariableResolver() {
        super("var", "some description");
    }

    @Override
    public void resolve(TemplateVariable variable, TemplateContext context) {
        final String name = variable.getName(); /* bar or baz */
        final List params = variable.getVariableType().getParams(); /* ["boolean"] */
        variable.setValues(computeSuggestions(name, params));
        variable.setResolved(true);
    }

    private String[] computeSuggestions(String name, List params) {
        return new String[] {"true", "false"};
        // TODO: more sophisticated proposals
    }

    // overwrite other methods!
}