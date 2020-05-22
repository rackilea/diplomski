public class RepeatableAction2Impl extends Action<RepeatableAction2> {

    @Override
    public CompletionStage<Result> call(Http.Context ctx) {
        if (configuration.value().length > 0) {
            int actions = configuration.value().length;
            List<Action<Action2>> actionList = new ArrayList<>();
            // Create actions
            for (int i = 0; i < actions; i++) {
                Action2Impl action2Impl = new Action2Impl();
                action2Impl.configuration = configuration.value()[i];
                actionList.add(action2Impl);
            }
            // Chaining
            actionList.get(actions - 1).delegate = delegate;
            for (int i = 0; i < actions - 1; i++) {
                actionList.get(i).delegate = actionList.get(i + 1);
            }
            // Delegate the work to actions
            return actionList.get(0).call(ctx);
        } else {
            return delegate.call(ctx);
        }
    }

}