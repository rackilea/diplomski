public void someMethod()
{
  if (isConditionMet())
    return new EvaluationResult(BagAttribute.createEmptyBag(attributeType));
}

private boolean isConditionMet()
{
  if (designatorType != AttributeDesignator.ENVIRONMENT_TARGET))
    return true;
  if (! attributeId.toString().equals("processor-load"))
    return true;
  if (! attributeType.toString().equals(IntegerAttribute.identifier))
    return true;
  return false;  
}