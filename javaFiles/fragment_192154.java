import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Builder {

    public static <E> E createInst(Class<E> c) throws InstantiationException, IllegalAccessException {
        //Class<?>[] type = new Class<?>[1];
        //type[0] = inst.class;
        try {
            Constructor<E> ctor = c.getConstructor(String.class); //c.getConstructor(type);
            return (ctor.newInstance("Testing"));
        } catch (NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }

}