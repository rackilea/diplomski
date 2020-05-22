public class ResponseViewEntity<T> extends ResponseEntity<ContainerViewEntity<T>> {

    private Class<? extends BaseView> view;

    public ResponseViewEntity(HttpStatus statusCode) {
        super(statusCode);
    }

    public ResponseViewEntity(T body, HttpStatus statusCode) {
        super(new ContainerViewEntity<T>(body, BaseView.class), statusCode);
    }

    public ResponseViewEntity(T body, Class<? extends BaseView> view, HttpStatus statusCode) {
        super(new ContainerViewEntity<T>(body, view), statusCode);
    }

}