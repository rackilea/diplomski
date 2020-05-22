@Stateless
public class Foo {
    ...
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public Object foo() {
        try {
            entityManager.insert(stuff);
            return stuff;
        } catch (PersistenceException e) {
            if (e.getCause() instanceof ConstraintViolationException) {
                // At this point the transaction has been rolled-backed.
                // Return null or use some other way to indicate a constrain
                // violation
                return null;
            }
            throw e;
        }
    }

    // Method extracted from foo() for loading the object.
    public Object load() {
        ...
    }
}

// On another EJB
@EJB
private Foo fooBean;

public Object doSomething() {
    Object foo = fooBean.insert();
    if (foo == null) {
        return fooBean.load();
    }

    return foo;
}