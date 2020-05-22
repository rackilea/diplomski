class ConditionSerialiser extends CustomSerializer[Condition]( format => (

{
    def deserialiseCondition:PartialFunction[JValue, Condition]= {
      case JObject(List(JField("field", JString(field)), JField("operator", JString(operator)), JField("value", JString(value)))) => BasicStringExpression(field, operator, value)
      case JObject(List(JField("field", JString(field)), JField("operator", JString(operator)), JField("value", JInt(value)))) => BasicNumericExpression(field, operator, value.doubleValue)
      case JObject(List(JField("field", JString(field)), JField("operator", JString(operator)), JField("value", JDouble(value)))) => BasicNumericExpression(field, operator, value)
      case JObject(List(JField("leftExpr", leftExpr), JField("logicalOperator", JString(logicalOperator)), JField("rightExpr", rightExpr))) => BooleanExpression(deserialiseCondition(leftExpr), logicalOperator, deserialiseCondition(rightExpr))
    }
    deserialiseCondition
},
{
  case bse: BasicStringExpression => JObject(List(JField("field", JString(bse.field)), JField("operator", JString(bse.operator)), JField("value", JString(bse.value))))       
}
))