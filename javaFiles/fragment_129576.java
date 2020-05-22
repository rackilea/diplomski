public class Service {
    public void invoke(RequestWrapper<?> wrapper) {
        try {
            // ...
            wrapper.invoke(this);
        } catch(Exception e ) {
            // ...
        }
    }

    public void invoke(String request) {
        System.out.println("String:" + request);
    }   

    public void invoke(Boolean request) {
        System.out.println("Boolean:" + request);
    }       

    public static void main(String[] args) {
        RequestWrapper<Boolean> rw = new BooleanRequestWrapper(Boolean.TRUE);

        new Service().invoke(rw);
    }
}

abstract class RequestWrapper<T> {
    protected final T request;

    public RequestWrapper(T request) {
        this.request = request;
    }

    public abstract void invoke(Service v);
}

class BooleanRequestWrapper extends RequestWrapper<Boolean> {

    public BooleanRequestWrapper(Boolean request) {
        super(request);
    }

    public void invoke(Service service) {
        service.invoke(request);
    }
}