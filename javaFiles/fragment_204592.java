public class HandlerRegistry
{
    private Map<Class<?>, Object> map = new HashMap<Class<?>, Object>();

    public <R extends Result, A extends Action<R>>
        void addHandler(Class<A> actionClass, ActionHandler<R, A> handler) {
        map.put(actionClass, handler);
    }

    @SuppressWarnings("unchecked")
    public <R extends Result, A extends Action<R>> ActionHandler<R, A>
        findHandler(A action) {
            return (ActionHandler<R, A>) map.get(action.getClass());
    }
}