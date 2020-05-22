@Name("nonEjbComponent")
public class NonEjbComponent {

    private @In WrapperStateless wrapperStateless;

    public void wrapperAllOfThem() {
        wrapperStateless.wrapperAllOfThem();
    }

}