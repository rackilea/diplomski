public static void main(String[] args) throws Exception {
    String[] examples = { 
            "RuleResult executeRule(RuleData, RuleProperties, Locale) { /* some key */ }", 
            "RuleResult executeRule() { /* some key */ }",
            "executeRule(RuleData, RuleProperties, Locale) { /* some key */ }", 
            "executeRule() { /* some key */ }",
            "static executeRule(RuleData, RuleProperties, Locale) { /* some key */ }", 
            "static executeRule() { /* some key */ }" };
    for (String example : examples) {
        System.out.println(example + "\n// result: " + 
            example.replaceAll(".*(?<=^|\\s)(\\w+\\(.*?\\)).*", "$1") + "\n");
    }
}