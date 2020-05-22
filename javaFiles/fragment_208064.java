public class Variable implements ExpressionNode {
    private final String name;

    public double getValue(Map<String, Double> variableValues) {
        if (variableValues.containsKey(name)) {
            return variableValues.get(name);
        } else {
            throw new EvaluationException(name + " is undefined");
        }
    }

    public String getExpressionText() {
        return name;
    }

    public List<String> getAllVariables() {
        return Arrays.asList(name);
    }
}