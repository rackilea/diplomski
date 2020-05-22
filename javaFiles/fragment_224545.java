import java.lang.reflect.Field;

import javax.annotation.Resource;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class SessionPerConversationInterceptor {
    private final static ThreadLocal<EntityManager> s_thEntityManager = new ThreadLocal<>();

    @AroundInvoke
public Object manageEntityManager(InvocationContext ctx) throws java.lang.Exception {
    EntityManager em = s_thEntityManager.get();
    if (em == null) {
        MasterPersistenceContext traversableEntityManager = ctx.getTarget().getClass().getAnnotation(MasterPersistenceContext.class);
        if (traversableEntityManager != null) {
            for (Field field : ctx.getTarget().getClass().getDeclaredFields()) {
                if (field.getAnnotation(PersistenceContext.class) != null) {
                    field.setAccessible(true);
                    em = (EntityManager) field.get(ctx.getTarget());
                    s_thEntityManager.set(em);

                    try {
                        Object oRet = ctx.proceed();
                        return oRet;
                    } finally {
                        s_thEntityManager.set(null);
                    }
                }
            }
        }
    } else if (ctx.getTarget().getClass().getAnnotation(MasterPersistenceContext.class) == null) {
        for (Field field : ctx.getTarget().getClass().getDeclaredFields()) {
            if (field.getAnnotation(PersistenceContext.class) != null) {
                field.setAccessible(true);

                EntityManager oldEntityManager = (EntityManager) field.get(ctx.getTarget());

                field.set(ctx.getTarget(), em);

                try {
                    Object oRet = ctx.proceed();
                    return oRet;
                } finally {
                    field.set(ctx.getTarget(), oldEntityManager);
                }
            }
        }
    }

    return ctx.proceed();
}
}