@Inject
@Presenter("loginView")
private Event<Object> viewEvent;

public void onLoginView(@Observes @Presenter("loginView") Object viewEvent) {
    ... whatever has to happen
}