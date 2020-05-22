Map<BooleanBuilder,String> caseExpressionMap = new LinkedHashMap<>();
CaseBuilder.Cases<String,SimpleExpression<String>> cases = null;
for(BooleanBuilder expression : caseExpressionMap.keySet()){
  if(caseExpression!=null)
    caseExpression = caseExpression.when(expression).then(caseExpressionMap.get(expression));
 else
    caseExpression = new CaseBuilder().when(expression).then(caseExpressionMap.get(expression));
}
cases=cases.otherwise(...)