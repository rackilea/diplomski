public final Object call(String methodName, Object[] parameters, Class[] parameterTypes) throws RetryingException, RemoteException {
    try {
        callMethod(methodName, parameters, parameterTypes)
    } catch (Exception ex) {
        // Handle any exception here...
    }
}

protected Object callMethod(String methodName, Object[] parameters, Class[] parameterTypes) throws RetryingException, RemoteException {
    // .. your code
}