import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.aspectj.lang.Signature;
import org.aspectj.lang.SoftException;

public aspect ImportantMethodInterceptor {
    Map<Object, Set<Object>> importantObjects = new HashMap<Object, Set<Object>>(); 

    pointcut importantSetter(Object newValue, Object target) :
        set(@Important * *) && args(newValue) && target(target);
    pointcut unimportantSetter(Object newValue, Object target) :
        !set(@Important * *) && set(* *) && !withincode(*.new(..)) && args(newValue) && target(target);
    pointcut publicMethod(Object target) :
        execution(public * *(..)) && target(target) && !execution(public String *..toString());

    before(Object newValue, Object target) : importantSetter(newValue, target) {
        Object oldValue = getFieldValue(thisJoinPoint.getSignature(), target);
        System.out.println("Important object for target " + target + ": " + oldValue + " -> " + newValue);
        synchronized (importantObjects) {
            Set<Object> referrers;
            if (oldValue != null) {
                referrers = importantObjects.get(oldValue);
                if (referrers != null) {
                    referrers.remove(target);
                    if (referrers.size() == 0)
                        importantObjects.remove(oldValue);
                }
            }
            if (newValue != null) {
                referrers = importantObjects.get(newValue);
                if (referrers == null) {
                    referrers = new HashSet<Object>();
                    importantObjects.put(newValue, referrers);
                }
                referrers.add(target);
            }
        }
    }

//  before(Object newValue, Object target) : unimportantSetter(newValue, target) {
//      Object oldValue = getFieldValue(thisJoinPoint.getSignature(), target);
//      System.out.println("Unimportant object for target " + target + ": " + oldValue + " -> " + newValue);
//  }

    before(Object target) : publicMethod(target) {
        synchronized (importantObjects) {
            if (importantObjects.get(target) != null)
                System.out.println("Important method on " + target + ": " + thisJoinPointStaticPart);
            else
                System.out.println("Unimportant method on " + target + ": " + thisJoinPointStaticPart);
        }
    }

    private Object getFieldValue(Signature signature, Object target) {
        try {
            Field field = signature.getDeclaringType().getDeclaredField(signature.getName());
            field.setAccessible(true);
            return field.get(target);
        }
        catch (Exception e) { throw new SoftException(e); }
    } 
}