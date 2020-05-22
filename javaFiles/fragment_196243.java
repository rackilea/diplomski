public class MyStrategy {
    public void executeChoosenMethod(int i) {
        Option.values()[i].execute(this);
    }

    private void action1() {
        System.out.println("action1");
    }

    private void action2() {
        System.out.println("action2");
    }

    private enum Option {
        Option1(MyStrategy::action1), 
        Option2(MyStrategy::action2);

        private InvokeAction methodToExecute;

        private Option(InvokeAction method) {
            methodToExecute = method;
        }

        public void execute(MyStrategy s) {
            methodToExecute.execute(s);
        }
    }

    @FunctionalInterface
    private interface InvokeAction {
        void execute(MyStrategy s);
    }
}