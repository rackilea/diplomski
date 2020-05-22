public static void main(String args[]) {
    for (int i = 99; i > 0; i--)
        doSomething(i);
}

public static void doSomething(int arg) {
    if (arg == 1 || arg == 2 || arg == 3)
        doSomething(--arg);
    if (arg == 1 || arg == 2 || arg == 3)
        System.out.println(arg);
    // Sandbox.arg = arg;
}