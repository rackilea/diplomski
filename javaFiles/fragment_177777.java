import java.io.Serializable;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

public class MyHbnInterceptor extends EmptyInterceptor {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        if(entity instanceof MyClass) {
            // TODO: Do your operations here
        }
        return super.onSave(entity, id, state, propertyNames, types);
    }
}