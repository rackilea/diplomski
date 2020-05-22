import java.lang.annotation.Annotation;

import org.aspectj.lang.SoftException;
import org.aspectj.lang.reflect.MethodSignature;

public aspect ArgCatcherAspect {
    before() : execution(public * *(.., @Constraint (*), ..)) {
        System.out.println(thisJoinPointStaticPart);
        MethodSignature signature = (MethodSignature) thisJoinPoint.getSignature();
        String methodName = signature.getMethod().getName();
        Class<?>[] parameterTypes = signature.getMethod().getParameterTypes();
        Annotation[][] annotations;
        try {
            annotations = thisJoinPoint.getTarget().getClass().
                getMethod(methodName, parameterTypes).getParameterAnnotations();
        } catch (Exception e) {
            throw new SoftException(e);
        }
        int i = 0;
        for (Object arg : thisJoinPoint.getArgs()) {
            for (Annotation annotation : annotations[i]) {
                if (annotation.annotationType() == Constraint.class)
                    System.out.println("  " + annotation + " -> " + arg);
            }
            i++;
        }
    }
}