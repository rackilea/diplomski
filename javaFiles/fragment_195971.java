public class VariableReplace {
    private class Substitution {
        private final String variable;
        private final String value;

        private Substitution(String variable, String value) {
            this.variable = variable;
            this.value = value;
        }

        public String getRegex() {
            return "((\\\\)*)\\{\\Q" + variable + "\\E\\}";
        }

        public String getValue() {
            return "$1" + value;
        }
    }

    private final List<Substitution> substitutions = new ArrayList<>();

    public void replace(String variable, String foo) {
        substitutions.add(new Substitution(variable, foo));
    }

    public String replaceVariables(String s) {
        String result = s;
        for (Substitution substitution : substitutions) {
            result = result.replaceAll(substitution.getRegex(), substitution.getValue());
        }
        result = result.replaceAll("\\\\(.)", "$1");
        return result;
    }
}