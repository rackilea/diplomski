@Qualifier
@Target({TYPE, METHOD, PARAMETER, FIELD})
@Retention(RUNTIME)
public @interface EventType {
    Class<?> value();
}


public class Dispatcher {

    @Inject @Any
    private Event<A> event;

    public void fireEvent(A a) {
            this.event.select(
                    getTypeAnnotation(
                    a.getClass())).fire(a);
    }

    public static EventType getTypeAnnotation(
            final Class<?> type) {
        return (EventType) Proxy.newProxyInstance(
                Thread.currentThread().getContextClassLoader(),
                new Class<?>[]{EventType.class},
                new InvocationHandler() {

            @Override
            public Object invoke(Object proxy, Method method,
                    Object[] args) throws Throwable {
                if (method.equals(
                        EventType.class.getMethod("value"))) {
                    return type;
                } else if (method.equals(Annotation.class.getMethod(
                        "annotationType"))) {
                    return EventType.class;
                } else if (method.getName().equals("hashCode")) {
                    return 127 * "value".hashCode() ^ type.hashCode();
                } else if (method.getName().equals("equals")) {
                    return (args[0] instanceof EventType &&
                            ((EventType)args[0]).value()
                            .equals(type));
                }
                return null;
            }
        });
    }
}

public class X {
    public void observeA(
            @Observes @EventType(AA.class) A a) {
    ...