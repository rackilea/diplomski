@EJB
SomeEJBLocal anotherme;

public void loop() {
    for(/* something */) {
        anotherme.single();
    }
}

@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public void single() {
    // do stuff
}