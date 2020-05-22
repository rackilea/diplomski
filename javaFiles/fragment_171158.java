abstract class P {

    int p1;
    int p2;

    public abstract HandlerFactory<? extends P> getHandlerFactory();
}

class P1 extends P {

    int p3;
    int p4;

    @Override
    public HandlerFactory<P1> getHandlerFactory() {
        return new P1HandlerFactory(this);
    }
}

class P2 extends P {

    int p5;
    int p6;

    @Override
    public HandlerFactory<? extends P> getHandlerFactory() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

abstract class HandlerFactory<T extends P> {

    private T t;

    public HandlerFactory(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public abstract DatabaseHandler<T> getDatabaseHandler();

    public abstract JMSHandler<T> getJMSHandler();
}

abstract class Handler<T extends P> {

    private final T t;

    public Handler(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }
}

abstract class DatabaseHandler<T extends P> extends Handler<T> {

    public DatabaseHandler(T t) {
        super(t);
    }

    public abstract void persist(Connection con);
}

abstract class JMSHandler<T extends P> extends Handler<T> {

    public JMSHandler(T t) {
        super(t);
    }

    public abstract void send();
}

class P1HandlerFactory extends HandlerFactory<P1> {

    public P1HandlerFactory(P1 t) {
        super(t);
    }

    @Override
    public DatabaseHandler<P1> getDatabaseHandler() {
        return new P1DatabaseHandler(getT());
    }

    @Override
    public JMSHandler<P1> getJMSHandler() {
        return new P1JMSHandler(getT());
    }
}

class P1DatabaseHandler extends DatabaseHandler<P1> {

    public P1DatabaseHandler(P1 p1) {
        super(p1);
    }

    @Override
    public void persist(Connection con) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

class P1JMSHandler extends JMSHandler<P1> {

    public P1JMSHandler(P1 p1) {
        super(p1);
    }

    @Override
    public void send() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}