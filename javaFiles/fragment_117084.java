public class ConstructorAdvice {
    @Advice.OnMethodExit
    public static void enter(@Advice.Origin String method,
                             @Advice.AllArguments Object[] para,
                             @Advice.FieldValue(value = "contextTimer", readOnly = false) Timer.Context contextTimer)
            throws Exception {

        if (getMethodName(method).equals("BalConnectorCallback")) {
            contextTimer = metricServer.getResponsesTime().start();
        }

    }