public class ErrorExtension implements ConcordionExtension {
    private List<AssertListener> listeners = new ArrayList<AssertListener>();

    public void addAssertEqualsListener(AssertListener listener) {
        listeners.add(listener);
    }

    public void removeAssertEqualsListener(AssertListener listener) {
        listeners.remove(listener);
    }

    @Override
    public void addTo(ConcordionExtender concordionExtender) {
        concordionExtender.withCommand("urn:error-extension:2017", "isError", new AbstractCommand() {
            @Override
            public void verify(CommandCall commandCall, Evaluator evaluator, ResultRecorder resultRecorder) {
                Check.isFalse(commandCall.hasChildCommands(), "Nesting commands inside an 'isError' is not supported");

                Element element = commandCall.getElement();

                String actual = (String) evaluator.evaluate(commandCall.getExpression());

                if (actual.contains("ERROR")) {
                    resultRecorder.record(Result.SUCCESS);
                    announceSuccess(element);
                } else {
                    resultRecorder.record(Result.FAILURE);
                    announceFailure(element, "String containing ERROR", actual);
                }
            }
        });
        listeners.add(new AssertResultRenderer());
    }

    private void announceSuccess(Element element) {
        for (AssertListener listener : listeners) {
            listener.successReported(new AssertSuccessEvent(element));
        }
    }

    private void announceFailure(Element element, String expected, Object actual) {
        for (AssertListener listener : listeners) {
            listener.failureReported(new AssertFailureEvent(element, expected, actual));
        }
    }
}