//MyPresenter.class
@Inject @ChangeType(Role.USER)
private Event<NotifyChange> userEvent;

@Inject @ChangeType(Role.CUSTOMER)
private Event<NotifyChange> custumerEvent;

public void updateUser() {
    userEvent.fire(new NotifyChange());
}

public void updateCustomer() {
    custumerEvent.fire(new NotifyChange());
}


//MyView.class
public void listenUserChange(
        @Observes @ChangeType(Role.USER) NotifyChange evt) {
}

void listenCustomerChange(
        @Observes @ChangeType(Role.CUSTOMER) NotifyChange evt) {
}

//Role.class
public enum Role {
USER, CUSTOMER
}

//ChangeType 
@Qualifier
@Target({ PARAMETER, FIELD })
@Retention(RUNTIME)
    public @interface ChangeType {

    Role value();
}