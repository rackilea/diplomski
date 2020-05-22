/**
 * Provides a simple write-one, read-many wrapper for an object reference for those situations
 * where you have an instance variable which you would like to declare as final but can't because
 * the instance initialization extends beyond construction.
 * <p>
 * An example would be <code>java.awt.Applet</code> with its constructor, <code>init()</code> and
 * <code>start()</code> methods.
 * <p>
 * Threading Design : [ ] Single Threaded  [x] Threadsafe  [ ] Immutable  [ ] Isolated
 *
 * @since           Build 2010.0311.1923
 */

public class WormRef<T>
extends Object
{

private volatile T                      reference;                              // wrapped reference

public WormRef() {
    super();

    reference=null;
    }

public WormRef<T> init(T val) {
    // Use synchronization to prevent a race-condition whereby the following interation could happen between three threads
    //
    //  Thread 1        Thread 2        Thread 3
    //  --------------- --------------- ---------------
    //  init-read null
    //                  init-read null
    //  init-write A
    //                                  get A
    //                  init-write B
    //                                  get B
    //
    // whereby Thread 3 sees A on the first get and B on subsequent gets.
    synchronized(this) {
        if(reference!=null) { throw new IllegalStateException("The WormRef container is already initialized"); }
        reference=val;
        }
    return this;
    }

public T get() {
    if(reference==null) { throw new IllegalStateException("The WormRef container is not initialized"); }
    return reference;
    }

} // END PUBLIC CLASS