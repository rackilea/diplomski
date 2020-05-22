public class Test {

    public static List<String> variablesArray(String expression) {
        if (expression != null) {
            ArrayList<String> vars = new ArrayList<String>();
            Pattern p = Pattern.compile("[a-z][a-z0-9]*", Pattern.CASE_INSENSITIVE);
            Matcher m = p.matcher(expression);
            while (m.find()) {
                vars.add(m.group());
            }
            return vars;
        }
        return null;
    }

    public static void main(String[] args) {
        List<String> vars = variablesArray("BMI=(Weight/(Height*Height)) * 70");
        for (String var : vars) {
            System.out.println(var);
        }
    }
}