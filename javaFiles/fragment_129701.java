String expression = "SUM_ALL(4:5,5:6)>MAX(6:7)<SUM_ALL(4:5,5:6)";
String mat = "";
Map<String, Double> functionOperators = new HashMap<String,Double>();
functionOperators.put("SUM_ALL(4:5,5:6)", 4.0);
functionOperators.put("MAX(6:7)",5.0);
Matcher m = 
    Pattern.compile(
            "(?:(SUM_ALL|MAX|MIN)\\(((?:\\d+:\\d+,?){1,2})\\)[+-><\\*/]?)")
            .matcher(expression);
while (m.find()) {
    mat = String.format("%s(%s)", m.group(1), m.group(2));
    expression = expression.replace(mat, functionOperators.get(mat).toString());
}
System.out.println(expression);