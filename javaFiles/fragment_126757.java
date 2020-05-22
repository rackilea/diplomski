public void method(Object... args) {
    if (args.length % 2 != 0) throw new IllegalArgumentException();
    for (int i = 0; i < args.length; i += 2) {
        String s = (String)args[i + 0];
        int i = (Integer)args[i + 1];

        ...
    }
}