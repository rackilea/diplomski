import java.util.HashMap;
import java.util.Map;

public class Factory<T> {

    private Map<Param, T> instances = new HashMap<Param, T>();

    public final T create(Class<T> clazz, Param param) throws Exception {
        T cur = instances.get(param);

        if (cur == null) {
             cur = clazz.newInstance();
             ((Base)cur).setParam(param);
             instances.put(param, cur);
        }
        return cur;
    }
}