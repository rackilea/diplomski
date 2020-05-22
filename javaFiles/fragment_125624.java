public String doSomething(final boolean throwException) {
    return logAndCleanup(() -> {                
        if (throwException) {
            throw new Exception("you asked for it");
        }
        return "hello";                
    });
}