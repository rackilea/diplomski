public abstract class BasePresenter {

    private List<HandlerRegistration> registrations = Lists.newLinkedList();

    public void bind() {}

    public void unbind() {
        for(HandlerRegistration registration : registrations) {
            registration.removeHandler();
        }
        registrations.clear();
    }

    protected void addHandler(HandlerRegistration registration) {
        registrations.add(registration);
    }

}