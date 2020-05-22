final class ActionEventObservable extends Observable<ActionEvent> {

    final AbstractButton widget;

    ActionEventObservable(AbstractButton widget) {
        this.widget = widget;
    }

    @Override 
    protected void subscribeActual(Observer<? super ActionEvent> observer) {
        AbstractButton w = widget;
        ActionEventConsumer aec = new ActionEventConsumer(observer, w);
        observer.onSubscribe(aec);
        w.addActionListener(aec);
        if (aec.get() == null) {
            w.removeActionListener(aec);
        }
    }

    static final class ActionEventConsumer
            extends AbstractEventConsumer<ActionEvent, AbstractButton>
            implements ActionListener {

        private static final long serialVersionUID = -3605206827474016488L;

        ActionEventConsumer(Observer<? super ActionEvent> actual, AbstractButton widget) {
            super(actual, widget);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            actual.onNext(e);
        }

        @Override
        protected void onDispose(AbstractButton component) {
            component.removeActionListener(this);
        }
    }
}