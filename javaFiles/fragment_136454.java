@FunctionalInterface
public interface FooInterface extends Serializable {

    void method();

    default String getName() {
        try {
            Method writeReplace = this.getClass().getDeclaredMethod("writeReplace");
            writeReplace.setAccessible(true);
            SerializedLambda sl = (SerializedLambda) writeReplace.invoke(this);
            return sl.getImplClass() + "::" + sl.getImplMethodName();
        } catch (Exception e) {
            return null;
        }
    }
}