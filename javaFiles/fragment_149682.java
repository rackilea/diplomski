private void executeSCCE()
{
    // register a handler for each Marker type
    ClassToHandlerMap dispatch = new ClassToHandlerMap();
    dispatch.put(B.class, new B_Handler());
    dispatch.put(C.class, new C_Handler());

    // get a target (e.g., Pair<A,C>)
    Pair<A, ? extends Marker> p1 = getTarget();

    // select handler based on the class type of the second parameter
    captureHelper(p1.second.getClass(), p1, dispatch);
}