ObjectFactory objectFactory = new ObjectFactory()
BinaryLogicOpType _or = new BinaryLogicOpType();
JAXBElement<BinaryLogicOpType> root = objectFactory.createOr(_or);

BinaryComparisonOpType weightIsLessThan100 = new BinaryComparisonOpType();
_or.getOps()
  .add(objectFactory.createPropertyIsLessThan(weightIsLessThan100));

JAXBElement<String> weightValueReference = 
    objectFactory.createValueReference("weight");
LiteralType _100 = new LiteralType();
_100.getContent().add(100);
JAXBElement<LiteralType> _100Literal = objectFactory.createLiteral(_100);

weightIsLessThan100.getExpression().add(weightValueReference);
weightIsLessThan100.getExpression().add(_100Literal);