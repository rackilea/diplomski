@PostConstruct
public void init() {
    try {
        data = loadFromWebservice();
    } catch (SomeException e) {
        log(e);
        addFacesMessage();
    }
}