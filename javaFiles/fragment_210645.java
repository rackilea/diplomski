public class BaseSelectorComposer<T> extends SelectorComposer<Window> {

    private HibernateSearch<T> searchObject;
    private final Class<T> theType;

    public BaseSelectorComposer(Class<T> token) {
        theType = token;
    }

    ...
    @Override
    public void doAfterCompose(Window comp) throws Exception {
        super.doAfterCompose(comp);
        this.searchObject = new HibernateSearchObject<T>(theType);
        ...
    }
    ...
}