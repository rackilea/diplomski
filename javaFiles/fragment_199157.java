public static <T> Signal<T> inject(Class<? extends T> type) {
        return null;
    }

    public void execute(MyInterface callback){
        Signal<MyInterface> signal = inject(callback.getClass());
        signal.addListener(callback);
    }