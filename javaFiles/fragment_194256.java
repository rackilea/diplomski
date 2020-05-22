/**
 * Cast a CheckedException as an unchecked one.
 *
 * @param throwable to cast
 * @param <T>       the type of the Throwable
 * @return this method will never return a Throwable instance, it will just throw it.
 * @throws T the throwable as an unchecked throwable
 */
@SuppressWarnings("unchecked")
public static <T extends Throwable> RuntimeException rethrow(Throwable throwable) throws T {
    throw (T) throwable; // rely on vacuous cast
}