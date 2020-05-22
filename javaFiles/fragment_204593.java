@SuppressWarnings("unchecked")
    public <R extends Result, A extends Action<R>> ActionHandler<R, ? super A>
        findHandler( A action ) {
            for ( Map.Entry<Class<?>, Object> entry : map.entrySet() )
            {
                if (entry.getKey().isAssignableFrom(action.getClass())) {
                    return (ActionHandler<R, ? super A>) entry.getValue();
                }
            }
            return null;
    }