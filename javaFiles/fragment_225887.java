public class CopyErrorsInterceptor extends AbstractInterceptor {


    public String intercept(ActionInvocation invocation) throws Exception {
        ValueStack stack =  invocation.getStack();
        CompoundRoot root = stack.getRoot();
        Action currentAction = (Action) invocation.getAction();
        if (root.size() > 1 && isValidationAware(currentAction)) {
            Action callerAction = getFirstActionBelow(root, currentAction);
            if (callerAction != null && isValidationAware(callerAction)) {
                ValidationAware currentActionVal = (ValidationAware) currentAction;
                ValidationAware callerActionVal = (ValidationAware) callerAction;

                //Copy the errors to the chained action.
                currentActionVal.setActionErrors(callerActionVal.getActionErrors());
                currentActionVal.setFieldErrors(callerActionVal.getFieldErrors());
            }
        }

        return invocation.invoke();
    }

    /**
     * Gets the first action below the passed action.
     * @param root the stack to find the action
     * @param current is the current action.
     * @return
     */
    private Action getFirstActionBelow(CompoundRoot root, Action current) {
        boolean foundCurrentAction = false;
        for(Object obj : root) {
            if (obj == current) {
                foundCurrentAction = true;
            } else {
                if (obj instanceof Action && foundCurrentAction) {
                    return (Action) obj;
                }
            }
        }
        return null;
    }

    private boolean isValidationAware(Action action) {
        return action instanceof ValidationAware;
    }

}