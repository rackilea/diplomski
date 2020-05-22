import org.aspectj.lang.reflect.FieldSignature;

import java.lang.reflect.Field;

public aspect FieldAuditAspect {

pointcut auditField(Object t, Object value): set(@(*.AopAudit) * *.*) && args(value) && target(t);

pointcut auditType(Object t, Object value): set(* @(*.AopAudit) *.*) && args(value) && target(t);

before(Object target, Object newValue): auditField(target, newValue) || auditType(target, newValue) {
        FieldSignature sig = (FieldSignature) thisJoinPoint.getSignature();
        Field field = sig.getField(); 
        field.setAccessible(true);

        Object oldValue;
        try
        {
            oldValue = field.get(target);
        }
        catch (IllegalAccessException e)
        {
            throw new RuntimeException("Failed to create audit Action", e);
        }

        Action a = new Action();
        a.setFieldName(sig.getName());
        a.setOldValue(oldValue == null ? null : oldValue.toString());
        a.setNewValue(newValue == null ? null : newValue.toString());
    }

}