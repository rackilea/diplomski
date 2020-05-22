public class InvocationCounter {

    public static <T> T countInvocations(T mock, AtomicInteger count) {
        return Mockito.verify(mock, new Counter(count));
    }

    private InvocationCounter(){}

    private static class Counter implements VerificationInOrderMode, VerificationMode {
        private final AtomicInteger count;

        private Counter(AtomicInteger count) {
            this.count = count;
        }

        public void verify(VerificationData data) {
            count.set(data.getAllInvocations().size());
        }

        public void verifyInOrder(VerificationDataInOrder data) {
            count.set(data.getAllInvocations().size());
        }

        @Override
        public VerificationMode description(String description) {
            return VerificationModeFactory.description(this, description);
        }

    }

}