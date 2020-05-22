public class CustomScriptTaskListener extends ScriptTaskListener {

    private Expression autoStoreVariablesExp;

    public void setAutoStoreVariablesExp(Expression autoStoreVariablesExp) {
        this.autoStoreVariablesExp = autoStoreVariablesExp;
    }

    @Override
    public void notify(DelegateTask delegateTask) {
        autoStoreVariables = Boolean.TRUE.equals(autoStoreVariablesExp.getValue(delegateTask));

        super.notify(delegateTask);
    }
}