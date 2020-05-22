public void myMethod() {
    try {
        getClientByNumber(1);
    } catch (NotUniqueResultException e) {
        //something that deals with the exception of that specific type.
    } catch (ClientNotFoundException e) {
        //something else that deals with the exception of that specific type.
    }
}