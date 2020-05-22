public class OnInfoEvaluator extends EventEvaluatorBase<ILoggingEvent> {

    @Override
    public boolean evaluate(ILoggingEvent loggingEvent) throws NullPointerException, EvaluationException {
        if(loggingEvent.getLevel().toInt() >= Level.INFO_INT)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}