protected Scope computeEnclosingScope() {
    Class<?> receiver = getRecvr();

    Method m = receiver.getEnclosingMethod();
    if (m != null)
        // Receiver is a local or anonymous class enclosed in a method.
        return MethodScope.make(m);

    // ...
}