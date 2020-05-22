public class DummyAggregationStrategy implements AggregationStrategy {

    @Override
    public MuleEvent aggregate(AggregationContext context) throws MuleException {
        if(context.collectEventsWithoutExceptions().isEmpty())
            return new DefaultMuleMessage();
        else
            return DefaultMuleEvent.copy(context.collectEventsWithoutExceptions().get(0));
    }
}