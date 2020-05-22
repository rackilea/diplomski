package api;

public final class Exposed {
    static {
        // Declare classes in the implementation package as 'friends'
        Accessor.setInstance(new AccessorImpl());
    }

    // Only accessible by 'friend' classes.
    Exposed() {

    }

    // Only accessible by 'friend' classes.
    void sayHello() {
        System.out.println("Hello");
    }

    static final class AccessorImpl extends Accessor {
        protected Exposed createExposed() {
            return new Exposed();
        }

        protected void sayHello(Exposed exposed) {
            exposed.sayHello();
        }
    }
}