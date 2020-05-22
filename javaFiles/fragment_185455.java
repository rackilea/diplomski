import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;

public class HibernateProxyReplacer {

    @SuppressWarnings("unchecked")
    public <T extends Entity> T replaceProxies(T entity) {
        try {
            return (T) replaceProxies(entity, new ArrayList<Object>());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    private Object replaceProxies(Object entity, List<Object> processedObjects) throws Exception {
        entity = getImplementation(entity);
        if (isProcessed(entity, processedObjects)) {
            return entity;
        }
        processedObjects.add(entity);

        for (Field field : getDeclaredFields(entity)) {
            if (isStaticOrFinal(field)) {
                continue;
            }
            field.setAccessible(true);
            Object value = field.get(entity);
            if (value == null) {
                continue;
            }
            Hibernate.initialize(value);
            if (value instanceof Collection) {
                replaceProxiesInCollection((Collection<Object>) value, processedObjects);
            } else if (value instanceof Entity) {
                field.set(entity, replaceProxies(value, processedObjects));
            }
        }

        return entity;
    }

    private Object getImplementation(Object object) {
        return object instanceof HibernateProxy ? ((HibernateProxy) object).getHibernateLazyInitializer().getImplementation() : object;
    }

    private boolean isStaticOrFinal(Field field) {
        return ((Modifier.STATIC | Modifier.FINAL) & field.getModifiers()) != 0;
    }

    private List<Field> getDeclaredFields(Object object) {
        List<Field> result = new ArrayList<Field>(Arrays.asList(object.getClass().getDeclaredFields()));
        for (Class<?> superclass = object.getClass().getSuperclass(); superclass != null; superclass = superclass.getSuperclass()) {
            result.addAll(Arrays.asList(superclass.getDeclaredFields()));
        }
        return result;
    }

    private void replaceProxiesInCollection(Collection<Object> collection, List<Object> processedObjects) throws Exception {
        Collection<Object> deproxiedCollection = new ArrayList<Object>();
        for (Object object : collection) {
            deproxiedCollection.add(replaceProxies(object, processedObjects));
        }
        collection.clear();
        collection.addAll(deproxiedCollection);
    }

    private boolean isProcessed(Object object, List<Object> processedObjects) {
        for (Object processedObject : processedObjects) {
            // Intentional comparison by reference to avoid relying on equals/hashCode
            if (processedObject == object) {
                return true;
            }
        }
        return false;
    }
}