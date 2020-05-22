import java.lang.reflect.*;

public class Handler<B extends Base & I1> {
    private E instanceOfE = ...; // Not sure where you get the E from.
    private Constructor<B> ctor;

    public Handler(Class<B> ctype) {
        if (Modifier.isAbstract(ctype.getModifiers())) {
            throw new IllegalArgumentException(ctype + " is abstract");
        }
        if (!Modifier.isPublic(ctype.getModifiers())) {
            throw new IllegalArgumentException(ctype + " is not public");
        }
        try {
            ctor = ctype.getConstructor(E.class);
        } catch (NoSuchMethodException x) {
            throw new IllegalArgumentException(x);
        }
        Arrays.stream(ctor.getExceptionTypes())
              .filter(x -> !RuntimeException.class.isAssignableFrom(x)
                        && !Error.class.isAssignableFrom(x))
              .findFirst()
              .ifPresent(x -> throw new IllegalArgumentException(ctor + " declares a checked exception");
    }

    private B create() {
        try {
             return ctor.newInstance(instanceOfE);
        } catch (InvocationTargetException x) {
             Throwable cause = x.getCause();
             if (cause instanceof RuntimeException)
                 throw (RuntimeException) cause;
             if (cause instanceof Error)
                 throw (Error) cause;
             // This won't happen because we checked for
             // it in the constructor.
             throw new RuntimeException(cause);
        } catch (IllegalAccessException
               | InstantiationException x) {
             // These also won't happen because we checked
             // for it in the constructor.
             throw new RuntimeException(x);
        }
    }
}