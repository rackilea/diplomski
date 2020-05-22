public class MyExtension
        implements ExtensionFunction
{
    @Override
    public QName getName()
    {
        return new QName("http://example.org/my-project", "my-fun");
    }

    @Override
    public SequenceType getResultType()
    {
        return SequenceType.makeSequenceType(
                ItemType.INTEGER, OccurrenceIndicator.ONE);
    }

    @Override
    public SequenceType[] getArgumentTypes()
    {
        return new SequenceType[] {
            SequenceType.makeSequenceType(
                    ItemType.INTEGER, OccurrenceIndicator.ONE),
            SequenceType.makeSequenceType(
                    ItemType.INTEGER, OccurrenceIndicator.ONE)
        };
    }

    @Override
    public XdmValue call(XdmValue[] args) throws SaxonApiException
    {
        long first  = ((XdmAtomicValue)args[0].itemAt(0)).getLongValue();
        long second = ((XdmAtomicValue)args[0].itemAt(0)).getLongValue();
        long result = ...;
        return new XdmAtomicValue(result);
    }
}